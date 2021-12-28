package com.fide.repository;

import com.fide.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

    public List<Trade> findAll();

    public List<Trade> findBySymbolAndTypeAndTimestampBetween(String symbol, String type, Timestamp startDate, Timestamp endDate);

    public List<Trade> findBySymbolAndTimestampBetween(String stockSymbol, Timestamp startDate, Timestamp endDate );
}
