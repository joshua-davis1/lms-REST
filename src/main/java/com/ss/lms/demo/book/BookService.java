package com.ss.lms.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getBooks() { return bookRepository.findAll(); }

    public Book findById(int id) {
        if (bookRepository.findById(id).isPresent()) return bookRepository.findById(id).get();
        return null;
    }

    public void save(Book book) { bookRepository.save(book); }

    public Boolean update(int id, Book book) {
        if (bookRepository.findById(id).isPresent()) {
            book.setId(id);
            bookRepository.save(book);
            return Boolean.TRUE;
        }
        // no book found
        return Boolean.FALSE;
    }
}
