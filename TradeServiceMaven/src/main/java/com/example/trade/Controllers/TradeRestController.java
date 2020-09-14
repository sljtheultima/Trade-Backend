package com.example.trade.Controllers;

import com.example.trade.Service.TradeService;
import com.example.trade.model.Trade;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Trade>> getTradeByTickerByTicker(@RequestParam String ticker){
        return ResponseEntity.ok().body(tradeService.getTradeByTicker(ticker).get());
    }


}


