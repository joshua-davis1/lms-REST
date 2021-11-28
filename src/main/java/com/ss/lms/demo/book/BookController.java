package com.ss.lms.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getBooks() { return bookService.getBooks(); }

    @GetMapping("/{id}")
    @ResponseBody
    public Book findById(@PathVariable Integer id) { return bookService.findById(id); }

    @PostMapping()
    public void createBook(@RequestBody Book book) {
        System.out.println(book);
        bookService.save(book);
    }

}
