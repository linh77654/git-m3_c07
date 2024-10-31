package repository;

import model.Book;

import java.util.List;

public interface IBookRepository {
    void update(Book book);

    Book getByID(int id);

    void add(Book newBook);

    List<Book> getAll();

    boolean delete(int id);
}
