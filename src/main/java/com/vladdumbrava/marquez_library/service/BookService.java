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
        log.info("Created book with title: {}",book.getBookTitle());
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
                    book.setBookTitle(newBook.getBookTitle());
                    book.setBookAuthor(newBook.getBookAuthor());
                    book.setBookPublicationYear(newBook.getBookPublicationYear());
                    book.setBookCategory(newBook.getBookCategory());
                    book.setBookLanguage(newBook.getBookLanguage());
                    book.setBookPagesNumber(newBook.getBookPagesNumber());
                    book.setBookTotalCopiesNumber(newBook.getBookTotalCopiesNumber());
                    book.setBookAvailableCopiesNumber(newBook.getBookAvailableCopiesNumber());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> bookRepository.save(newBook));
        log.info("Updated book with id: {}", updatedBook.getBookId());
        return updatedBook;
    }

    public Book updateBookTotalCopiesNumber(Long id, Integer totalCopiesNumber) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setBookTotalCopiesNumber(totalCopiesNumber);
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
    }

}
