package my.library.demo.controller;

import my.library.demo.model.Author;
import my.library.demo.model.Book;
import my.library.demo.service.IAuthorService;
import my.library.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    IBookService bookService;

    @Autowired
    IAuthorService authorService;

    @RequestMapping("/book")
    public String book(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("books",bookList);
        return "bookList";
    }

    @RequestMapping("/addBookPage")
    public String addBookPage(Model model) {
        List<Author> authors = authorService.findAll();
//        for(Author a:authors){
//            System.out.println(a.getId());
//            System.out.println(a.getFullName());
//        }
        model.addAttribute("authors",authors);
        return "addBook";
    }
//, @RequestParam("authors") List<Long> authors
    @PostMapping("/addBook")
    public String addBook(Book book) {
//        for (Long id : authors){
//            System.out.println(id);
//        }
//    public String addBook() {
//        System.out.println(book.getFullName());
        bookService.save(book);
        return "redirect:/book";
    }
}
