package com.conygre.training.tradesimulator.Controllers;

import com.conygre.training.tradesimulator.model.Trade;
import com.conygre.training.tradesimulator.sim.TradeSim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TradeRestController {

    @Autowired
    TradeSim tradesim;

    @GetMapping("/getTrades")
    public ResponseEntity<List<Trade>> getAllTrades(){
        return ResponseEntity.ok().body(tradesim.findTradesForProcessing());
    }
}
