package com.vladdumbrava.marquez_library.repository;

import com.vladdumbrava.marquez_library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
