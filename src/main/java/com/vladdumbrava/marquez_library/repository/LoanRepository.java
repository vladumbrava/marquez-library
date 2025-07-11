package com.vladdumbrava.marquez_library.repository;

import com.vladdumbrava.marquez_library.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
