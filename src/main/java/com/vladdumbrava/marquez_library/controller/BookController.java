package com.vladdumbrava.marquez_library.controller;

import com.vladdumbrava.marquez_library.model.Book;
import com.vladdumbrava.marquez_library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }


    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book newBook) {
        return bookService.updateBook(id, newBook);
    }

    @PatchMapping("/{id}")
    public Book updateBookTotalCopiesNumber(@PathVariable("id") Long id,
                                            @RequestBody Integer newTotalCopiesNumber) {
        return bookService.updateBookTotalCopiesNumber(id, newTotalCopiesNumber);
    }
}
