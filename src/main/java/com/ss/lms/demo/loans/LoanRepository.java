package com.ss.lms.demo.loans;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan,LoanId> {
    @Query(value = "SELECT * FROM tbl_book_loans WHERE book_id= :bookId",nativeQuery = true)
    List<Loan> findAllByBookId(Integer bookId);

    @Query(value = "SELECT * FROM tbl_book_loans WHERE branch_id= :branchId",nativeQuery = true)
    List<Loan> findAllByBranchId(Integer branchId);

    @Query(value = "SELECT * FROM tbl_book_loans WHERE card_no= :cardNo",nativeQuery = true)
    List<Loan> findAllByCardNo(Integer cardNo);
}
