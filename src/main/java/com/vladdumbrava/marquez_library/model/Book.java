package com.vladdumbrava.marquez_library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "books")
@Data
@ToString
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publication_year")
    private String publicationYear;

    @Column(name = "category")
    private String category;

    @Column(name = "language")
    private String language;

    @Column(name = "pages_number")
    private Integer pagesNumber;

    @Column(name = "total_copies_number")
    private Integer totalCopiesNumber;

    @Column(name = "available_copies_number")
    private Integer availableCopiesNumber;

}
