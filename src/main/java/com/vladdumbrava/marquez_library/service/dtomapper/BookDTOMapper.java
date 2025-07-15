package com.vladdumbrava.marquez_library.service.dtomapper;

import com.vladdumbrava.marquez_library.dto.BookDTO;
import com.vladdumbrava.marquez_library.model.Book;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BookDTOMapper implements Function<Book, BookDTO> {
    @Override
    public BookDTO apply(Book book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear(),
                book.getCategory(),
                book.getLanguage(),
                book.getPagesNumber(),
                book.getTotalCopiesNumber(),
                book.getAvailableCopiesNumber()
        );
    }
}
