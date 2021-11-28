package com.ss.lms.demo.loans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/loan")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping()
    public List<Loan> findAll() { return loanService.findAll(); }

    @GetMapping("/branch/{branchId}")
    @ResponseBody
    public List<Loan> findAllByBranch(@PathVariable Integer branchId) { return loanService.findAllByBranchId(branchId);}

    @GetMapping("/book/{bookId}")
    @ResponseBody
    public List<Loan> findAllByBook(@PathVariable Integer bookId) { return loanService.findAllByBookId(bookId);}

    @GetMapping("/customer/{cardNo}")
    @ResponseBody
    public List<Loan> findAllByBorrower(@PathVariable Integer cardNo) { return loanService.findAllByCardNo(cardNo);}

    @PostMapping
    public void createLoan(@RequestBody Loan loan) { loanService.save(loan); }

    @PutMapping()
    public void updateLoan(@RequestBody Loan loan) { loanService.update(loan);}
}
