package my.library.demo.service;

import my.library.demo.model.Author;
import my.library.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> findByFullNameContaining(String name) {
        List<Author> authorList = authorRepository.findByFullNameContaining(name);
        return authorList;
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = authorRepository.findAll();
        return authors;
    }
}
