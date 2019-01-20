package my.library.demo.repository;

import my.library.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findByFullNameContaining(String fullName);
    Author findAuthorById(Long id);
}
