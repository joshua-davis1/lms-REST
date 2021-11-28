package com.ss.lms.demo.branch;

import com.ss.lms.demo.loans.Loan;
import com.ss.lms.demo.loans.LoanService;
import com.ss.lms.demo.stock.Stock;
import com.ss.lms.demo.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/branch")
public class BranchController {

    private final BranchService branchService;
    private final LoanService loanService;
    private final StockService stockService;

    @Autowired
    public BranchController(BranchService branchService, LoanService loanService, StockService stockService) {
        this.branchService = branchService;
        this.loanService = loanService;
        this.stockService = stockService;
    }

    @GetMapping()
    public List<Branch> findAll() { return branchService.findAll(); }

    @GetMapping("/{branchId}")
    @ResponseBody
    public Branch findById(@PathVariable Integer branchId) { return branchService.findById(branchId); }

    @GetMapping("/{branchId}/loans")
    @ResponseBody
    public List<Loan> findAllBranchLoans(@PathVariable Integer branchId) { return loanService.findAllByBranchId(branchId); }

    @GetMapping("/{branchId}/inventory")
    @ResponseBody
    public List<Stock> findAllBranchBooks(@PathVariable Integer branchId) { return stockService.findByBranchId(branchId); }

    @PostMapping()
    public void createBranch(@RequestBody Branch branch) { branchService.save(branch); }

    @PutMapping("/{branchId}")
    public void updateBranch(@PathVariable Integer branchId, @RequestBody Branch branch) {
        Boolean success = branchService.update(branchId, branch);
        System.out.println("Update Success: "+success);
    }
}
