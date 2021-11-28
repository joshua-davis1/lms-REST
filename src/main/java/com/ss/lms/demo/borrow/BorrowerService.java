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

    public Borrower findById(int id) {
        if (borrowerRepository.findById(id).isPresent()) return borrowerRepository.findById(id).get();
        return null;
    }

    public void save(Borrower borrower) { borrowerRepository.save(borrower); }

    public Boolean update(int id, Borrower borrower) {
        if (borrowerRepository.findById(id).isPresent()) {
            borrower.setId(id);
            borrowerRepository.save(borrower);
            return Boolean.TRUE;
        }
        // no borrower found
        return Boolean.FALSE;
    }
}
