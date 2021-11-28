package com.ss.lms.demo.loans;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LoanId implements Serializable {

    private Integer branchId;
    private Integer cardNo;
    private Integer bookId;

    public LoanId(Integer branchId, Integer cardNo, Integer bookId) {
        this.branchId = branchId;
        this.cardNo = cardNo;
        this.bookId = bookId;
    }

    public LoanId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanId loanId = (LoanId) o;
        return branchId.equals(loanId.branchId) && cardNo.equals(loanId.cardNo) && bookId.equals(loanId.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, cardNo, bookId);
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getCardNo() {
        return cardNo;
    }

    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "LoanId{" +
                "branchId=" + branchId +
                ", cardNo=" + cardNo +
                ", bookId=" + bookId +
                '}';
    }
}
