package uz.market.marketapplicationdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.market.marketapplicationdemo.entity.Product;
import uz.market.marketapplicationdemo.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product create(Product product){
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public Product findOne(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            Product product1 = product.get();
            return product1;
        }
        return null;
    }
    @Transactional(readOnly = true)
    public Page<Product> allProduct(Pageable pageable){
        Page<Product> page = productRepository.findAll(pageable);
        return page;
    }
    public void delete(Long id){
        productRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Product findByCode(String code){
        return productRepository.findByCode(code);
    }
}
