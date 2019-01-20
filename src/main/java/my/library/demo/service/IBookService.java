package my.library.demo.service;

import my.library.demo.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
//    void save(Book book, List<Long> authorsId);
    void save(Book book);
    List<Book> findByAuthor(String author);
}
