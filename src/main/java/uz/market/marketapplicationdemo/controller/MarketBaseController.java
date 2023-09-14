package uz.market.marketapplicationdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.market.marketapplicationdemo.entity.MarketBase;
import uz.market.marketapplicationdemo.entity.dto.PaymentParamResults;
import uz.market.marketapplicationdemo.service.MarketBaseService;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MarketBaseController {
    private final MarketBaseService marketBaseService;

    @PostMapping("/market-base")
    public ResponseEntity<?> create(@RequestBody MarketBase marketBase){
        if (marketBase.getId()==null){
            marketBase.setCreatedDate(ZonedDateTime.now());
        }
        MarketBase marketBase1 = marketBaseService.create(marketBase);
        return ResponseEntity.ok(marketBase1);
    }
    @PutMapping("/market-base")
    public ResponseEntity<?> update(@RequestBody MarketBase marketBase){
        MarketBase marketBase1 = marketBaseService.create(marketBase);
        return ResponseEntity.ok(marketBase1);
    }
    @PostMapping("/market-base/list")
    public ResponseEntity<?> saveList(@RequestBody List<MarketBase> marketBases){
        List<MarketBase> marketBases1 = marketBaseService.saveList(marketBases);
        return ResponseEntity.ok("Products are registered");
    }
    @GetMapping("/market-base/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        MarketBase one = marketBaseService.findOne(id);
        return ResponseEntity.ok(one);
    }
    @GetMapping("/market-base")
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<MarketBase> all = marketBaseService.findAll(pageable);
        return ResponseEntity.ok(all);
    }
    @GetMapping("/market-base/code")
    public ResponseEntity<?> getByProductCode(@RequestParam String code){
        MarketBase byProductCode = marketBaseService.findByProductCode(code);
        return ResponseEntity.ok(byProductCode);
    }
    @GetMapping("/market-base/productCode")
    public ResponseEntity<?> getByProductCode(@RequestParam String code,@RequestParam Integer quantity){
        PaymentParamResults paramResults = marketBaseService.findByProductCode(code, quantity);
        return ResponseEntity.ok(paramResults);
    }

    @DeleteMapping("/market-base/{id}")
    public void delete(@PathVariable long id){
        marketBaseService.deleteById(id);
    }



}
