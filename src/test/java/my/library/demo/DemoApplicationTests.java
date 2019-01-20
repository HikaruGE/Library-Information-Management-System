package my.library.demo;

import my.library.demo.model.Author;
import my.library.demo.model.Book;
import my.library.demo.model.User;
import my.library.demo.repository.AuthorRepository;
import my.library.demo.repository.BookRepository;
import my.library.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
        Book b = bookRepository.findOneByFullName("mirror origin");
        Author xiaoming = new Author();
        xiaoming.setFullName("xiaoming");
        b.getAuthors().add(xiaoming);
        bookRepository.save(b);



//        Author a = authorRepository.findOneByFullName("cangyue");
    }

    @Test
    public void userRepository(){
        User user = userRepository.findByUsername("tt");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }

    @Test
    public void findByFullNameContaining(){

    }

}

