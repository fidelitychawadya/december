package com.fide.service;

import com.fide.model.Trade;
import com.fide.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TradeService {

    @Autowired
    TradeRepository tradeRepository;

    public ResponseEntity<String> createTrade(Trade request){
        Optional<Trade> trade = Optional.of(new Trade());
        trade = tradeRepository.findById(request.getId());
        if (trade != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            Trade newTrade = tradeRepository.save(request);
            if (newTrade != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(null);
            } else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }
    }

    public ResponseEntity<String> eraseAllTrades() {
        tradeRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    public ResponseEntity<Optional<Trade>> findByTradeId(Long tradeID) {
        Optional<Trade> trade = tradeRepository.findById(tradeID);
        return ResponseEntity.status(HttpStatus.OK).body(trade);
    }

    public ResponseEntity<List<Trade>> findAll() {
        List<Trade> trade = tradeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(trade);
    }

    public ResponseEntity<List<Trade>> findTradesByUserID(Long userID){
        List<Trade> trade = tradeRepository.findAll();
        trade.stream().filter(tradeByUserId -> tradeByUserId.getUser().getId()
        .equals(userID)).collect(Collectors.toList());
        if (trade.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(trade);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(trade);
        }

    }

    public ResponseEntity<List<Trade>> tradeRecords(String stockSymbol, String tradeType, Timestamp startDate, Timestamp endDate) {
        List<Trade> trade = tradeRepository.findBySymbolAndTypeAndTimestampBetween(stockSymbol, tradeType, startDate, endDate);
        if (trade.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(trade);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(trade);
        }
    }

    public ResponseEntity<List<Trade>> highestAndLowestPrices(String stockSymbol, Timestamp startDate, Timestamp endDate) {
        List<Trade> trades = tradeRepository.findBySymbolAndTimestampBetween(stockSymbol, startDate, endDate);
        List<Trade> tradePrice = new ArrayList<>();

        tradePrice.add(trades.stream().min(Comparator.comparing(Trade::getPrice)).orElseThrow(null));
        tradePrice.add(trades.stream().max(Comparator.comparing(Trade::getPrice)).orElseThrow(null));

        if (trades.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(tradePrice);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(tradePrice);
        }

    }



}
