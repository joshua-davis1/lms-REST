package com.ss.lms.demo.loans;

import com.ss.lms.demo.stock.Stock;
import com.ss.lms.demo.stock.StockId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> findAll() { return loanRepository.findAll(); }

    public List<Loan> findAllByBookId(Integer bookId) { return loanRepository.findAllByBookId(bookId); }

    public List<Loan> findAllByBranchId(Integer branchId) { return loanRepository.findAllByBranchId(branchId); }

    public List<Loan> findAllByCardNo(Integer cardNo) { return  loanRepository.findAllByCardNo(cardNo); }

    public Loan findById(LoanId loanId) {
        if (loanRepository.findById(loanId).isPresent()) return loanRepository.getById(loanId);
        return null;
    }

    public void save(Loan loan) { loanRepository.save(loan); }

    public Boolean update(Loan loan) {
        if (loanRepository.findById(loan.getLoanId()).isPresent()) {
            loanRepository.save(loan);
            return Boolean.TRUE;
        }
        // no loan found
        return Boolean.FALSE;
    }

}
