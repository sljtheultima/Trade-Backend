package com.example.trade.Service;

import com.example.trade.dao.TradeMongoDao;
import com.example.trade.model.Trade;
import com.example.trade.model.TradeState;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TradeService {
    @Autowired
    private TradeMongoDao tradeMongoDao;

    public Object insertNewTrade(Trade t) {return tradeMongoDao.save(t);}

    public List<Trade> getAllTrades(){
        return tradeMongoDao.findAll();
    }

    public Optional<Trade> getTradeById(ObjectId id){
        return tradeMongoDao.findById(id);
    }

    public Optional<List<Trade>> getTradeByState(TradeState state){
        return tradeMongoDao.findByState(state);
    }

    public Optional<List<Trade>> getTradeByTicker(String ticker){
        return tradeMongoDao.findByTicker(ticker);
    }



}
