package com.conygre.training.tradesimulator.Service;

import com.conygre.training.tradesimulator.dao.TradeMongoDao;
import com.conygre.training.tradesimulator.model.Trade;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class TradeService {
    @Autowired
    TradeMongoDao tradeMongoDao;
    public List<Trade> getAllTrades(){
        return tradeMongoDao.findAll();
    }
    public Optional<Trade> getTradeById(ObjectId id){
        return tradeMongoDao.findById(id);
    }
    public Trade getTradeByTicker(String ticker){
        return tradeMongoDao.findByTicker(ticker);
    }



}
