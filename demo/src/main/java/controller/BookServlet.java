package controller;

import model.Book;
import service.BookService;
import service.IBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IBookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "list":
                listBooks(request, response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                addBook(request, response);
                break;
            case "edit":
                updateBook(request, response);
                break;
            default:
                listBooks(request, response);
                break;
        }
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.getAll();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("books.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Book book = bookService.getBookById(id);

            if (book != null) {
                request.setAttribute("book", book);
                RequestDispatcher dispatcher = request.getRequestDispatcher("editBook.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("book?action=list");
            }
        } catch (NumberFormatException e) {
            try {
                response.sendRedirect("book?action=list");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (ServletException | IOException e) {

            e.printStackTrace();
            try {
                response.sendRedirect("errorPage.jsp"); 
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addBook.jsp");
        dispatcher.forward(request, response);
    }


    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {
            int bookId = Integer.parseInt(id);
            Book book = bookService.getBookById(bookId);

            if (book != null) {
                request.setAttribute("book", book);  // Đặt thuộc tính "book" để hiển thị thông tin sách trên trang xác nhận
                RequestDispatcher dispatcher = request.getRequestDispatcher("confirmDelete.jsp");
                dispatcher.forward(request, response);
            } else {

                response.sendRedirect("book?action=list");
            }
        } else {
            response.sendRedirect("book?action=list");
        }
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        Book book = new Book(id, title, pageSize, author, category);
        bookService.update(book);

        response.sendRedirect("book");
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        String author = request.getParameter("author");
        String category = request.getParameter("category");

        Book newBook = new Book(0,title,pageSize,author,category);
        bookService.add(newBook);
        response.sendRedirect("book");
    }
}
