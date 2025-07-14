package com.vladdumbrava.marquez_library.controller;

import com.vladdumbrava.marquez_library.model.Book;
import com.vladdumbrava.marquez_library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

}
