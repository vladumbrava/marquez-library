package com.vladdumbrava.marquez_library.dto;

import java.time.LocalDate;

public record LoanDTO (
   long id,
   long bookId,
   long memberId,
   LocalDate loanDate,
   LocalDate dueDate,
   LocalDate returnDate,
   String status
) {}
