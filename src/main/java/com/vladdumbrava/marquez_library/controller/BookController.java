package com.vladdumbrava.marquez_library.controller;

import com.vladdumbrava.marquez_library.dto.BookDTO;
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
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }


    @PutMapping("/{id}")
    public void updateBook(@PathVariable("id") Long id, @RequestBody Book newBook) {
        bookService.updateBook(id, newBook);
    }

    @PatchMapping("/update-total-copies/{id}")
    public void updateBookTotalCopiesNumber(@PathVariable("id") Long id,
                                            @RequestBody Integer newTotalCopiesNumber) {
        bookService.updateBookTotalCopiesNumber(id, newTotalCopiesNumber);
    }

    @PatchMapping("/update-available-copies/{id}")
    public void updateBookAvailableCopiesNumber(@PathVariable("id") Long id,
                                                @RequestBody Integer newAvailableCopiesNumber) {
        bookService.updateBookAvailableCopiesNumber(id, newAvailableCopiesNumber);
    }
}
