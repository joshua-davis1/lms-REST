package com.ss.lms.demo.book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ss.lms.demo.author.Author;
import com.ss.lms.demo.publisher.Publisher;
import com.ss.lms.demo.stock.Stock;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Entity(name="Book")
@Table(name="tblBook")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pub_id", nullable = false)
    private Publisher publisher;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tblBookAuthors",
            joinColumns = { @JoinColumn(name = "bookId") },
            inverseJoinColumns = { @JoinColumn(name = "authorId") })
    private Set<Author> authors = new HashSet<>();
    @JsonBackReference
    @OneToMany(mappedBy = "book")
    Set<Stock> inventory;

    public Book(String title, Publisher publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public Set<Stock> getInventory() {
        return inventory;
    }

    public void setInventory(Set<Stock> inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publisher=" + publisher +
                ", authors=" + authors +
                '}';
    }
}
