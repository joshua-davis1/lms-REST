package com.ss.lms.demo.borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerService {

    private final BorrowerRepository borrowerRepository;

    @Autowired
    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public List<Borrower> findAll() { return borrowerRepository.findAll(); }

    public Borrower findById(int id) { return borrowerRepository.findById(id).get(); }

    public void save(Borrower borrower) { borrowerRepository.save(borrower); }
}
