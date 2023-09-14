package uz.market.marketapplicationdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.market.marketapplicationdemo.entity.PaymentList;
import uz.market.marketapplicationdemo.service.PaymentListService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentListService paymentListService;

    @PostMapping("/paymentlist")
    public ResponseEntity<?> create(@RequestBody PaymentList paymentList){
        PaymentList paymentList1 = paymentListService.create(paymentList);
        return ResponseEntity.ok(paymentList1);
    }
    @PutMapping("/paymentlist")
    public ResponseEntity<?> update(@RequestBody PaymentList paymentList){
        PaymentList paymentList1 = paymentListService.create(paymentList);
        return ResponseEntity.ok(paymentList1);
    }

    @GetMapping("/paymentlist/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        PaymentList one = paymentListService.findOne(id);
        return ResponseEntity.ok(one);
    }
    @GetMapping("/paymentlist")
    public ResponseEntity<?> getOne(Pageable pageable){
        Page<PaymentList> one = paymentListService.findAll(pageable);
        return ResponseEntity.ok(one);
    }
    @DeleteMapping("/paymentlist/{id}")
    public void delete(@PathVariable Long id){
        paymentListService.delete(id);
    }
}
