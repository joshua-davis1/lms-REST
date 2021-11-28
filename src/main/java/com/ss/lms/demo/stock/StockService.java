package com.ss.lms.demo.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> findAll() { return stockRepository.findAll(); }

    public Stock findById(StockId stockId) {
        if (stockRepository.findById(stockId).isPresent()) return stockRepository.getById(stockId);
        return null;
    }

    public void save(Stock stock) { stockRepository.save(stock); }

    public Boolean update(Stock stock) {
        if (stockRepository.findById(new StockId(stock.getBookId(), stock.getBranchId())).isPresent()) {
            stockRepository.save(stock);
            return Boolean.TRUE;
        }
        // no stock found
        return Boolean.FALSE;
    }
}
