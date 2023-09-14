package uz.market.marketapplicationdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import uz.market.marketapplicationdemo.entity.Product;
import uz.market.marketapplicationdemo.service.ProductService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<?> create(@RequestBody Product product){
        Product product1 = productService.create(product);
        return ResponseEntity.ok(product1);
    }
    @PutMapping ("/product")
    public ResponseEntity<?> update(@RequestBody Product product){
        Product product1 = productService.create(product);
        return ResponseEntity.ok(product1);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<?> findone(@PathVariable Long id){
        Product one = productService.findOne(id);
        return ResponseEntity.ok(one);
    }
    @GetMapping("/product")
    public ResponseEntity<?> findAll(Pageable pageable){
        Page<Product> products = productService.allProduct(pageable);
        return ResponseEntity.ok(products);
    }
    @GetMapping("/product/code")
    public ResponseEntity getByCode(@RequestParam String code){
        Product byCode = productService.findByCode(code);
        return ResponseEntity.ok(byCode);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }
}
