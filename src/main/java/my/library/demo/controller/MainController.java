package my.library.demo.controller;

import my.library.demo.config.MyUserPrincipal;
import my.library.demo.model.Author;
import my.library.demo.model.Book;
import my.library.demo.repository.AuthorRepository;
import my.library.demo.repository.BookRepository;
import my.library.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String home(Model model){
//        MyUserPrincipal userDetails = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        userDetails.getUser().getUsername();
        return "index";
    }

    @RequestMapping("/search/author")
    public String searchByAuthor(Model model,@RequestParam("author") String author){
        model.addAttribute("books",bookRepository.findByAuthors_FullNameContaining(author));
        return "index";
    }

    @GetMapping("/main")
    public String main(Model model){

        List<Author> authorList = authorRepository.findAll();
        List<Book> bookList = bookRepository.findAll();

        model.addAttribute("authors",authorList);
        model.addAttribute("books",bookList);

        return "dashboard";
    }
}
