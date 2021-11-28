package com.ss.lms.demo.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public List<Author> getAuthors() { return authorService.findAll(); }

    @GetMapping("/{id}")
    @ResponseBody
    public Author findById(@PathVariable Integer id) { return authorService.findById(id); }

    @PostMapping
    public void createAuthor(@RequestBody Author author) { authorService.save(author); }

//    @PutMapping("/{id}")
//    public void updateAuthor(@PathVariable Integer id, @RequestBody Author author) { authorService.update(author); }

}
