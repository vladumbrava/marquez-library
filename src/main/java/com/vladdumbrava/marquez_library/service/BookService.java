package com.vladdumbrava.marquez_library.service;

import com.vladdumbrava.marquez_library.model.Book;
import com.vladdumbrava.marquez_library.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    public Book createBook(Book book) {
        log.info("Created book with title: {}",book.getTitle());
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book newBook) {
        log.info("Updating book ...");
        Book updatedBook = bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setAuthor(newBook.getAuthor());
                    book.setPublicationYear(newBook.getPublicationYear());
                    book.setCategory(newBook.getCategory());
                    book.setLanguage(newBook.getLanguage());
                    book.setPagesNumber(newBook.getPagesNumber());
                    book.setTotalCopiesNumber(newBook.getTotalCopiesNumber());
                    book.setAvailableCopiesNumber(newBook.getAvailableCopiesNumber());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> bookRepository.save(newBook));
        log.info("Updated book with id: {}", id);
        return updatedBook;
    }

    public Book updateBookTotalCopiesNumber(Long id, Integer totalCopiesNumber) {
        //the if statement is purposed to reflect that the library received
        //a new stock of books of that id, so that means we also increase the number
        //of available copies
        //maybe I should make a separate method that implements this logic and
        //call it addStockOfBooks or something similar
        Book updatedBook = bookRepository.findById(id)
                .map(book -> {
                    if (totalCopiesNumber > book.getTotalCopiesNumber()) {
                        book.setAvailableCopiesNumber(book.getAvailableCopiesNumber() +
                                totalCopiesNumber - book.getTotalCopiesNumber());
                    }
                    book.setTotalCopiesNumber(totalCopiesNumber);
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
        log.info("Updated total copies number for book with id: {}", id);
        return updatedBook;
    }

}
