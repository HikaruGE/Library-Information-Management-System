package my.library.demo.service;

import my.library.demo.model.Author;
import my.library.demo.model.Book;
import my.library.demo.repository.AuthorRepository;
import my.library.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> bookList = bookRepository.findByAuthors_FullNameContaining(author);
        return bookList;
    }

    @Override
    public List<Book> search(String keyWord, String type) {
        if(type.equals("a")){
            return bookRepository.findByAuthors_FullNameContaining(keyWord);
        }else if(type.equals("t")){
            return bookRepository.findByTitleContaining(keyWord);
        }else if(type.equals("i")){
            return bookRepository.findByIsbnContaining(keyWord);
        }
        return null;
    }
}
