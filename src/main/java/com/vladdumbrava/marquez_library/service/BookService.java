package com.vladdumbrava.marquez_library.service;

import com.vladdumbrava.marquez_library.dto.BookDTO;
import com.vladdumbrava.marquez_library.model.Book;
import com.vladdumbrava.marquez_library.repository.BookRepository;
import com.vladdumbrava.marquez_library.service.dtomapper.BookDTOMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookDTOMapper bookDTOMapper;
    private final BookRepository bookRepository;

    public void createBook(Book book) {
        log.info("Created book with title: {}",book.getTitle());
        bookRepository.save(book);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookDTOMapper)
                .collect(Collectors.toList());
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void updateBook(Long id, Book newBook) {
        log.info("Updating book ...");
        bookRepository.findById(id)
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
    }

    public void updateBookTotalCopiesNumber(Long id, Integer totalCopiesNumber) {
        bookRepository.findById(id)
                .map(book -> {
                    book.setTotalCopiesNumber(totalCopiesNumber);
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
        log.info("Updated total copies number for book with id: {}", id);
    }

    public void updateBookAvailableCopiesNumber(Long id, Integer availableCopiesNumber) {
        bookRepository.findById(id)
                .map(book -> {
                    book.setAvailableCopiesNumber(availableCopiesNumber);
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
        log.info("Updated available copies number for book with id: {}", id);
    }


}
