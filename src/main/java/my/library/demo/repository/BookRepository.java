package my.library.demo.repository;

import my.library.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book findOneByFullName(String fullName);
    List<Book> findByAuthors_FullNameContaining(String authors);
    List<Book> findByIsbnContaining(String isbn);
    List<Book> findByFullNameContaining(String fullName);
}

