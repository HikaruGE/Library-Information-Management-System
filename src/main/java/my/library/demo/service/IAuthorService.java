package my.library.demo.service;

import my.library.demo.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> findByFullNameContaining(String name);
    List<Author> findAll();
}
