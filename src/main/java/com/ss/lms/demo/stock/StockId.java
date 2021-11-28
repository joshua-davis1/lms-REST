package com.ss.lms.demo.stock;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
public class StockId implements Serializable {

    private Integer bookId;
    private Integer branchId;

    public StockId(Integer bookId, Integer branchId) {
        this.bookId = bookId;
        this.branchId = branchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockId stockId = (StockId) o;
        return bookId.equals(stockId.bookId) && branchId.equals(stockId.branchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, branchId);
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "StockId{" +
                "bookId=" + bookId +
                ", branchId=" + branchId +
                '}';
    }
}
