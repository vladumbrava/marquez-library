package com.vladdumbrava.marquez_library.controller;

import com.vladdumbrava.marquez_library.dto.LoanDTO;
import com.vladdumbrava.marquez_library.model.Loan;
import com.vladdumbrava.marquez_library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public void createLoan(@RequestBody Loan loan) {
        loanService.createLoan(loan);
    }

    @GetMapping
    public List<LoanDTO> getAllLoans() {
        return loanService.getAllLoans();
    }
}
