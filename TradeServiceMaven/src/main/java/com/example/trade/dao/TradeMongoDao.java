package com.example.trade.dao;

import com.example.trade.model.Trade;
import com.example.trade.model.TradeState;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TradeMongoDao extends MongoRepository<Trade, ObjectId>  {

	@Query(value="{ 'state' : ?0}")
	public List<Trade> findByState(String state);

	@Query(value="{ 'ticker' : ?0}")
	public List<Trade> findByTicker(String ticker);

	@Query(value="{ '_id' : ?0}")
	public List<Trade> findById(String id);

	@Query(value="{ 'type' : ?0}")
	public List<Trade> findByType(String type);
}