package com.ss.lms.demo.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/stock")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping()
    public List<Stock> findAllStock() { return stockService.findAll(); }

    @GetMapping("/{branchId}/{bookId}")
    @ResponseBody
    public Stock getStockById(@PathVariable Integer branchId, @PathVariable Integer bookId) { return stockService.findById(new StockId(bookId,branchId)); }

    @PostMapping()
    public void createStock(@RequestBody Stock stock) { stockService.save(stock); }

    @PutMapping("/{branchId}/{bookId}")
    public void updateStock(@PathVariable Integer branchId, @PathVariable Integer bookId, @RequestBody Stock stock) {
        stock.setBranchId(branchId);
        stock.setBookId(bookId);
        Boolean success = stockService.update(new StockId(bookId,branchId), stock);
        System.out.println("Update Success: "+success);
    }
}
