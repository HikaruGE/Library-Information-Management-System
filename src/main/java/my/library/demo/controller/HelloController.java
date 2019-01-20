package my.library.demo.controller;

import my.library.demo.model.Book;
import my.library.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloController {



    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }




}
