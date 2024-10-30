package repository;

import database.BaseRepository;
import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {

    @Override
    public void update(Book book) {
        String query = "UPDATE books SET name = ?, author = ? WHERE id = ?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book getByID(int id) {
        String query = "SELECT * FROM books WHERE id = ?";
        Book book = null;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                book = new Book(id, name, author);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void add(Book book) {
        String sql = "INSERT INTO books (name, author, category, pageSize) VALUES (?, ?, ?, ?)";
        try (Connection connection = BaseRepository.getConnection()) {
            if (connection != null) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, book.getName());
                    preparedStatement.setString(2, book.getAuthor());
                    preparedStatement.setString(3, book.getCategory());
                    preparedStatement.setInt(4, book.getPageSize());
                    preparedStatement.executeUpdate();
                }
            } else {
                System.out.println("Cannot establish connection to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông tin lỗi
        }
    }


    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try (Connection connection = BaseRepository.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int pageSize = resultSet.getInt("page_size");
                String author = resultSet.getString("author_id");
                String category = resultSet.getString("category_id");
                books.add(new Book(id, name, author, pageSize, category));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
