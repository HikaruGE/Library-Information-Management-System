package my.library.demo;

import my.library.demo.model.Author;
import my.library.demo.model.Book;
import my.library.demo.model.Role;
import my.library.demo.model.User;
import my.library.demo.repository.AuthorRepository;
import my.library.demo.repository.BookRepository;
import my.library.demo.repository.RoleRepository;
import my.library.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args){

        bookRepository.deleteAllInBatch();
        authorRepository.deleteAllInBatch();

        Book book1 = new Book();
        book1.setFullName("mirror origin");
        book1.setIsbn("ISBN-98076");
        Book book2 = new Book();
        book2.setFullName("mirror cloud");
        book2.setIsbn("ISBN-98072");
        Book book3 = new Book();
        book3.setFullName("two wives one husband");
        book3.setIsbn("ISBN-54213");
        Book book4 = new Book();
        book4.setFullName("wind and rose");
        book4.setIsbn("ISBN-31521");
        Book book5 = new Book();
        book5.setFullName("jingjiwangzuo");
        book5.setIsbn("ISBN-35331");

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);

        Author moon = new Author();
        moon.setFullName("cangyue");
        Author yunnan = new Author();
        yunnan.setFullName("shangejiao");
        Author jiangnan = new Author();
        jiangnan.setFullName("jiangnan");

        authorRepository.save(moon);
        authorRepository.save(yunnan);
        authorRepository.save(jiangnan);

        book1.getAuthors().add(moon);
        bookRepository.saveAndFlush(book1);
        book2.getAuthors().add(moon);
        bookRepository.save(book2);
        book3.getAuthors().add(yunnan);
        bookRepository.save(book3);
        book4.getAuthors().add(moon);
        book4.getAuthors().add(jiangnan);
        bookRepository.save(book4);
        book5.getAuthors().add(jiangnan);
        bookRepository.save(book5);

//        moon.getBooks().add(book1);
//        moon.getBooks().add(book2);
//        moon.getBooks().add(book4);
//        yunnan.getBooks().add(book3);
//        jiangnan.getBooks().add(book4);
//        jiangnan.getBooks().add(book5);
//
//        authorRepository.save(moon);
//        authorRepository.save(yunnan);
//        authorRepository.save(jiangnan);


        Role manager = new Role();
        manager.setName("manager");
        Role user = new Role();
        user.setName("user");
        roleRepository.save(manager);
        roleRepository.save(user);

        User user1 = new User();
        user1.setUsername("tt");
        user1.setPassword("123");
        user1.getRoles().add(manager);
        user1.getRoles().add(user);
        userRepository.save(user1);
//        user1.getBorrowedBooks().add(bookRepository.findOneByFullName("mirror origin"));
//        user1.getBorrowedBooks().add(bookRepository.findOneByFullName("mirror cloud"));
//        userReposotory.save(user1);

        User user2 = new User();
        user2.setUsername("ss");
        user2.setPassword("456");
        user2.getRoles().add(user);
        userRepository.save(user2);
//        user2.getBorrowedBooks().add(bookRepository.findOneByFullName("mirror origin"));
//        user2.getBorrowedBooks().add(bookRepository.findOneByFullName("mirror cloud"));
//        userReposotory.save(user2);

        Book bookSearch1 = bookRepository.findOneByFullName("mirror origin");
        bookSearch1.setBorrower(user1);
        bookRepository.save(bookSearch1);

        Book bookSearch2 = bookRepository.findOneByFullName("mirror cloud");
        bookSearch2.setBorrower(user1);
        bookRepository.save(bookSearch2);


//        bookRepository.save(book1);
//        bookRepository.save(book2);
//        bookRepository.save(book3);
//        bookRepository.save(book4);
//        bookRepository.save(book5);

//        moon.getBooks().add(book1);
//        moon.getBooks().add(book2);
//        moon.getBooks().add(book4);
//        yunnan.getBooks().add(book3);
//        jiangnan.getBooks().add(book4);
//        jiangnan.getBooks().add(book5);
//        authorRepository.save(moon);
//        authorRepository.save(yunnan);
//        authorRepository.save(jiangnan);

//        Book b = bookRepository.findOneByFullName("mirror origin");
//        Author xiaoming = new Author();
//        xiaoming.setFullName("xiaoming");
//        b.getAuthors().add(xiaoming);
//        bookRepository.save(b);
    }
}

