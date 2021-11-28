package com.ss.lms.demo.stock;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity(name="Stock")
@Table(name="tblBookCopies")
@IdClass(StockId.class)
public class Stock {

    @Id
    private Integer bookId;
    @Id
    private Integer branchId;
    @Column(name = "noOfCopies")
    private Integer qty;

    public Stock(Integer bookId, Integer branchId, Integer qty) {
        this.bookId = bookId;
        this.branchId = branchId;
        this.qty = qty;
    }

    public Stock(Integer qty) {
        this.qty = qty;
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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "bookId=" + bookId +
                ", branchId=" + branchId +
                ", qty=" + qty +
                '}';
    }
}
