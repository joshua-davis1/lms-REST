package com.ss.lms.demo.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, StockId> {
    @Query(value="SELECT * FROM tbl_book_copies WHERE branch_id= :branchId",nativeQuery = true)
    List<Stock> findByBranchId(Integer branchId);
}
