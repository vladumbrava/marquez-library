package com.vladdumbrava.marquez_library.service;

import com.vladdumbrava.marquez_library.dto.LoanDTO;
import com.vladdumbrava.marquez_library.model.Book;
import com.vladdumbrava.marquez_library.model.Loan;
import com.vladdumbrava.marquez_library.repository.BookRepository;
import com.vladdumbrava.marquez_library.repository.LoanRepository;
import com.vladdumbrava.marquez_library.repository.MemberRepository;
import com.vladdumbrava.marquez_library.service.dtomapper.LoanDTOMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanService {

    private final LoanDTOMapper loanDTOMapper;
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void createLoan(Loan loan) {
        Book book = bookRepository.findById(loan.getBookId())
                .orElseThrow(() -> new RuntimeException("Book with id " + loan.getBookId() + " not found"));

        if (book.getAvailableCopiesNumber() <= 0) {
            throw new RuntimeException("Book with id " + loan.getBookId() + " has no available copies");
        }

        memberRepository.findById(loan.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member with id " + loan.getMemberId() + " not found"));

        book.setAvailableCopiesNumber(book.getAvailableCopiesNumber() - 1);
        bookRepository.save(book);

        loanRepository.save(loan);
    }

    public List<LoanDTO> getAllLoans() {
        return loanRepository.findAll()
                .stream()
                .map(loanDTOMapper)
                .collect(Collectors.toList());
    }

}
