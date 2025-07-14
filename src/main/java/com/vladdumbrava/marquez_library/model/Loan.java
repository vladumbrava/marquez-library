package com.vladdumbrava.marquez_library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "loans")
@Data
@ToString
public class Loan {

    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_id")
    private long bookId;

    @Column(name = "member_id")
    private long memberId;

    @Column(name = "loan_date")
    private String loanDate;

    @Column(name = "due_date")
    private String dueDate;

    @Column(name = "return_date")
    private String returnDate;

    @Column(name = "status")
    private String status;
}
