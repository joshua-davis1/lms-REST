package com.ss.lms.demo.book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ss.lms.demo.author.Author;
import com.ss.lms.demo.publisher.Publisher;
import com.ss.lms.demo.stock.Stock;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Entity(name="Book")
@Table(name="tblBook")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId", unique = true, nullable = false)
    private Integer id;
    @Column(name = "bookTitle")
    private String title;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    @JsonBackReference
    @OneToMany(mappedBy = "book")
    Set<Stock> inventory;

    public Book(String title, Publisher publisher, Author author) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
                ", author=" + author +
                '}';
    }
}
