package my.library.demo.controller;

import my.library.demo.model.Author;
import my.library.demo.model.Book;
import my.library.demo.repository.AuthorRepository;
import my.library.demo.repository.BookRepository;
import my.library.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/main")
    public String main(Model model){

        List<Author> authorList = authorRepository.findAll();
        List<Book> bookList = bookRepository.findAll();

        model.addAttribute("authors",authorList);
        model.addAttribute("books",bookList);

        return "dashboard";
    }
}
