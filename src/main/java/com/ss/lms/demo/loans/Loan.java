package com.ss.lms.demo.loans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ss.lms.demo.book.Book;
import com.ss.lms.demo.borrow.Borrower;
import com.ss.lms.demo.branch.Branch;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name="Loan")
@Table(name="tbl_book_loans")
public class Loan {

    @EmbeddedId
    private LoanId loanId;
    private LocalDate dateIn = null;
    private LocalDate dateOut;
    private LocalDate dueDate;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "branchId", nullable = false, insertable = false, updatable = false)
    private Branch branch;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cardNo", nullable = false, insertable = false, updatable = false)
    private Borrower borrower;

    public Loan(LoanId loanId, LocalDate dateIn, LocalDate dateOut, LocalDate dueDate) {
        this.loanId = loanId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.dueDate = dueDate;
    }

    public Loan(LocalDate dateIn, LocalDate dateOut, LocalDate dueDate) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.dueDate = dueDate;
    }

    public Loan() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return loanId.equals(loan.loanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId);
    }

    public LoanId getLoanId() {
        return loanId;
    }

    public void setLoanId(LoanId loanId) {
        this.loanId = loanId;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                ", dueDate=" + dueDate +
                '}';
    }
}
