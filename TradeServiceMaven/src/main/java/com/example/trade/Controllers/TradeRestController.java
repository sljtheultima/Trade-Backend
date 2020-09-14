package com.example.trade.Controllers;

import com.example.trade.Service.TradeService;
import com.example.trade.model.Trade;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity<List<Trade>> getTradeById(@PathVariable String id){
        return ResponseEntity.ok().body(tradeService.getTradeById(id));
    }
    @GetMapping("/trade/state/{state}")
    public ResponseEntity<List<Trade>> getTradeByState(@PathVariable String state){
        return ResponseEntity.ok().body(tradeService.getTradeByState(state));
    }
    @GetMapping("/trade/ticker/{ticker}")
    public ResponseEntity<List<Trade>> getTradeByTicker(@PathVariable String ticker){
        return ResponseEntity.ok().body(tradeService.getTradeByTicker(ticker));
    }
    @GetMapping("/trade/type/{type}")
    public ResponseEntity<List<Trade>> getTradeByType(@PathVariable String type){
        return ResponseEntity.ok().body(tradeService.getTradeByType(type));
    }

    @PostMapping(value="/addNewTrade",consumes={"application/json"},
            produces={"application/json"})
    public ResponseEntity<Trade> addNewTrade (@RequestBody Trade trade) {
        System.out.println("Adding " + trade);
        tradeService.insertNewTrade(trade);
        URI uri = URI.create("/trade/new/" + trade.getTicker());
        return ResponseEntity.created(uri).body(trade);
    }


}


