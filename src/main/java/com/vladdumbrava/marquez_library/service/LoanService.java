package com.vladdumbrava.marquez_library.service;

import com.vladdumbrava.marquez_library.repository.LoanRepository;
import com.vladdumbrava.marquez_library.service.dtomapper.LoanDTOMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanService {

    private final LoanDTOMapper loanDTOMapper;
    private final LoanRepository loanRepository;

}
