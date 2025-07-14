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
    private long bookId;

    @Column(name = "title")
    private String bookTitle;

    @Column(name = "author")
    private String bookAuthor;

    @Column(name = "publication_year")
    private String bookPublicationYear;

    @Column(name = "category")
    private String bookCategory;

    @Column(name = "language")
    private String bookLanguage;

    @Column(name = "pages_number")
    private Integer bookPagesNumber;

    @Column(name = "total_copies_number")
    private Integer bookTotalCopiesNumber;

    @Column(name = "available_copies_number")
    private Integer bookAvailableCopiesNumber;

}
