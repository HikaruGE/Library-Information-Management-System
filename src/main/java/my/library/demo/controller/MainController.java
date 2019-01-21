package my.library.demo.controller;

import my.library.demo.model.Author;
import my.library.demo.model.Book;
import my.library.demo.repository.AuthorRepository;
import my.library.demo.repository.BookRepository;
import my.library.demo.repository.UserRepository;
import my.library.demo.service.IUserManageService;
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

    @Autowired
    IUserManageService userManageService;

    @RequestMapping("/")
    public String home(Model model){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",userManageService.searchUserByName(user.getUsername()));
        return "index";
    }

    @RequestMapping("/search/author")
    public String searchByAuthor(Model model,@RequestParam("author") String author){
        model.addAttribute("books",bookRepository.findByAuthors_FullNameContaining(author));
        return "index";
    }

    @RequestMapping("/search/isbn")
    public String searchByIsbn(Model model,@RequestParam("isbn") String isbn){
        model.addAttribute("books",bookRepository.findByIsbnContaining(isbn));
        return "index";
    }

    @RequestMapping("/search/name")
    public String searchByName(Model model,@RequestParam("name") String bookName){
        model.addAttribute("books",bookRepository.findByFullNameContaining(bookName));
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
