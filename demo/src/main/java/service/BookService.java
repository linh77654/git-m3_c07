package service;

import model.Book;
import repository.BookRepository;
import repository.IBookRepository;

import java.util.List;

public class BookService implements IBookService {
    private IBookRepository bookRepository = new BookRepository();

    @Override
    public void update(Book book) {
        bookRepository.update(book);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getByID(id);
    }

    @Override
    public void add(Book newBook) {
        bookRepository.add(newBook);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }
}
