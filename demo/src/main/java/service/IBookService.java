package service;

import model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();

    void update(Book book);

    Book getBookById(int id);

    void add(Book newBook);
    boolean delete(int id);
}
