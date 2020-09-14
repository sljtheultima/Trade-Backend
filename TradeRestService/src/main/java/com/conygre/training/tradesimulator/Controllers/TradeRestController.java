package com.conygre.training.tradesimulator.Controllers;

import com.conygre.training.tradesimulator.Service.TradeService;
import com.conygre.training.tradesimulator.model.Trade;
import com.conygre.training.tradesimulator.model.TradeState;
import com.conygre.training.tradesimulator.sim.TradeSim;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class TradeRestController {
    @Autowired
    TradeService tradeService;

    @GetMapping("/trades")
    public ResponseEntity<List<Trade>> getTrades(){
        return ResponseEntity.ok().body(tradeService.getAllTrades());
    }
    @GetMapping("/trade/{id}")
    public ResponseEntity<Trade> getTradeByTickerById(@PathVariable ObjectId id){
        return ResponseEntity.ok().body(tradeService.getTradeById(id).get());
    }
    @GetMapping("/trade")
    public ResponseEntity<Trade> getTradeByTickerByTicker(@RequestParam String ticker){
        return ResponseEntity.ok().body(tradeService.getTradeByTicker(ticker).get());
    }

}


