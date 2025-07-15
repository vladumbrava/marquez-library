package com.vladdumbrava.marquez_library.service.dtomapper;

import com.vladdumbrava.marquez_library.dto.LoanDTO;
import com.vladdumbrava.marquez_library.model.Loan;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class LoanDTOMapper implements Function<Loan, LoanDTO> {
    @Override
    public LoanDTO apply(Loan loan) {
        return new LoanDTO(
                loan.getId(),
                loan.getBookId(),
                loan.getMemberId(),
                loan.getLoanDate(),
                loan.getDueDate(),
                loan.getReturnDate(),
                loan.getStatus()
        );
    }
}
