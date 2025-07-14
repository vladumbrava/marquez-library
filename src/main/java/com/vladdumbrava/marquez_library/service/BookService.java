package com.vladdumbrava.marquez_library.service;

import com.vladdumbrava.marquez_library.model.Book;
import com.vladdumbrava.marquez_library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    public Book createBook(Book book) {
        log.info("Created book with title: {}",book.getBookTitle());
        return bookRepository.save(book);
    }
}
