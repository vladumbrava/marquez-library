package com.vladdumbrava.marquez_library.dto;

public record BookDTO (
   long id,
   String title,
   String author,
   String publicationYear,
   String category,
   String language,
   Integer pagesNumber,
   Integer totalCopiesNumber,
   Integer availableCopiesNumber
) {}
