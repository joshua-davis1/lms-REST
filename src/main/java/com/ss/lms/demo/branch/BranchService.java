package com.ss.lms.demo.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    private final BranchRepository branchRepository;

    @Autowired
    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<Branch> findAll() { return branchRepository.findAll(); }

    public Branch findById(int id) {
        if (branchRepository.findById(id).isPresent()) return branchRepository.findById(id).get();
        return null;
    }

    public void save(Branch branch) { branchRepository.save(branch); }

    public Boolean update(int id, Branch branch) {
        if (branchRepository.findById(id).isPresent()) {
            branch.setId(id);
            branchRepository.save(branch);
            return Boolean.TRUE;
        }
        // no branch found
        return Boolean.FALSE;
    }
}
