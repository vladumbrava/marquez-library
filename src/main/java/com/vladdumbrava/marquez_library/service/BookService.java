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
        log.info("Updated book with id: {}", updatedBook.getId());
        return updatedBook;
    }

    public Book updateBookTotalCopiesNumber(Long id, Integer totalCopiesNumber) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTotalCopiesNumber(totalCopiesNumber);
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
    }

}
