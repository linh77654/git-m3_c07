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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
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
        if (books == null) {
            books = new ArrayList<>();
        }
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
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addBook.jsp");
        dispatcher.forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deleteId = Integer.parseInt(request.getParameter("deleteId"));
        System.out.println("id: "+ deleteId);
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int pageSize = Integer.parseInt(request.getParameter("page_size"));
            String author = request.getParameter("author_id");
            String category = request.getParameter("category_id");
            Book book = new Book(id, name, pageSize, author, category);
            bookService.update(book);
            response.sendRedirect("book");
        } catch (NumberFormatException e) {
            response.sendRedirect("book?action=list");
        }
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String name = request.getParameter("name");
            int pageSize = Integer.parseInt(request.getParameter("page_size"));
            String author = request.getParameter("author_id");
            String category = request.getParameter("category_id");
            Book newBook = new Book(0, name, pageSize, author, category);
            bookService.add(newBook);
            response.sendRedirect("/book");
        } catch (NumberFormatException e) {
            response.sendRedirect("book?action=add");
        }
    }
}
