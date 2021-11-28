package com.ss.lms.demo.borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/borrower")
public class BorrowerController {

    private final BorrowerService borrowerService;

    @Autowired
    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @GetMapping()
    public List<Borrower> getBorrowers() { return borrowerService.findAll(); }

    @GetMapping("/{cardNo}")
    @ResponseBody
    public Borrower findBorrowerById(@PathVariable Integer cardNo) { return borrowerService.findById(cardNo); }

    @PostMapping()
    public void createBorrower(@RequestBody Borrower borrower) { borrowerService.save(borrower) ;}

    @PutMapping("/{id}")
    public void updateBorrower(@PathVariable Integer id, @RequestBody Borrower borrower) {
        Boolean success = borrowerService.update(id, borrower);
        System.out.println("Update Success: "+success);
    }

}
