package com.ss.lms.demo.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/branch")
public class BranchController {

    private final BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping()
    public List<Branch> findAll() { return branchService.findAll(); }

    @GetMapping("/{id}")
    @ResponseBody
    public Branch findById(@PathVariable Integer id) { return branchService.findById(id); }

    @PostMapping()
    public void createBranch(@RequestBody Branch branch) { branchService.save(branch); }

    @PutMapping("/{id}")
    public void updateBranch(@PathVariable Integer id, @RequestBody Branch branch) {
        Boolean success = branchService.update(id, branch);
        System.out.println("Update Success: "+success);
    }
}
