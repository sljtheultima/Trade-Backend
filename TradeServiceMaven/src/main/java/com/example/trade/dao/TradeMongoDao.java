package com.example.trade.dao;

import com.example.trade.model.Trade;
import com.example.trade.model.TradeState;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TradeMongoDao extends MongoRepository<Trade, ObjectId>  {

	public List<Trade> findByState(TradeState state);
	public Optional<List<Trade>> findByTicker(String ticker);
}