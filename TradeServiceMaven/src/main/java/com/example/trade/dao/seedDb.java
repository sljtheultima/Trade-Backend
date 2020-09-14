package com.example.trade.dao;

import com.example.trade.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class seedDb {

    @Autowired
    private TradeMongoDao repository;

    @PostConstruct
    public void init(){
        repository.deleteAll();
        repository.save(new Trade());
        repository.save(new Trade());
        repository.save(new Trade());
        repository.save(new Trade());
        repository.save(new Trade());
        repository.save(new Trade());
        repository.save(new Trade());

    }
}
