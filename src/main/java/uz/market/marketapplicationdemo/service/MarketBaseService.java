package uz.market.marketapplicationdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.market.marketapplicationdemo.entity.MarketBase;
import uz.market.marketapplicationdemo.entity.dto.PaymentParamResults;
import uz.market.marketapplicationdemo.repository.MarketBaseRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarketBaseService {
    private final MarketBaseRepository marketBaseRepository;

    public MarketBase create(MarketBase marketBase){
        return marketBaseRepository.save(marketBase);
    }

    public List<MarketBase> saveList(List<MarketBase> marketBases){
        List<MarketBase> marketBases1 = marketBaseRepository.saveAll(marketBases);
        return marketBases1;
    }
    @Transactional(readOnly = true)
    public MarketBase findByProductCode(String code){
        return marketBaseRepository.findTopByProductCode(code);
    }
    @Transactional(readOnly = true)
    public MarketBase findOne(Long id){
        Optional<MarketBase> byId = marketBaseRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        return null;
    }
    public PaymentParamResults findByProductCode(String code,Integer quantity){
        PaymentParamResults paramResults = marketBaseRepository.findByProductCode(code);
        paramResults.setSum(paramResults.getSum().multiply(new BigDecimal(""+quantity)));
        paramResults.setQuantity(quantity);
        return paramResults;
    }
    public Page<MarketBase> findAll(Pageable pageable){
        Page<MarketBase> all = marketBaseRepository.findAll(pageable);
        return all;
    }
    public void deleteById(Long id){
        marketBaseRepository.deleteById(id);
    }
}
