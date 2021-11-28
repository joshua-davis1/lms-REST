package com.ss.lms.demo.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() { return authorRepository.findAll(); }

    public Author findById(int id) {
        if(authorRepository.findById(id).isPresent()) return authorRepository.findById(id).get();
        return null;
    }

    public void save(Author author) { authorRepository.save(author); }

    public void update(int id, Author author) {
        if(authorRepository.findById(id).isPresent()) {

        }
    }
}
