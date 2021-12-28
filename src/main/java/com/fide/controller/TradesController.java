package com.fide.controller;

import com.fide.model.Trade;
import com.fide.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "")
public class TradesController {

    @Autowired
    TradeService tradeService;

    @PostMapping(value = "/trades")
    public ResponseEntity<String> createTrade(@RequestBody Trade trade) {
        return tradeService.createTrade(trade);
    }

    @DeleteMapping("/erase")
    public ResponseEntity<String> deleteAll() {
        return tradeService.eraseAllTrades();
    }

    @GetMapping(value = "/trades/{id}")
    public ResponseEntity<Optional<Trade>> findTradeById(@RequestParam Long tradeId) {
        return tradeService.findByTradeId(tradeId);
    }

    @GetMapping(value = "/trades")
    public ResponseEntity<List<Trade>> findAll() {
        return tradeService.findAll();
    }

    @GetMapping(value = "/trades/users/{userID}")
    public ResponseEntity<List<Trade>> findTradesByUserID(@RequestParam Long userID) {
        return tradeService.findTradesByUserID(userID);
    }

    @GetMapping(value = "/stocks/{stockSymbol}/price?start={startDate}&end={endDate}")
    public ResponseEntity<List<Trade>> highestAndLowestPrices(@RequestParam String stockSymbol, @RequestParam Timestamp startDate, @RequestParam Timestamp endDate) {
        return tradeService.highestAndLowestPrices(stockSymbol, startDate, endDate);
    }
}
