package uz.market.marketapplicationdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.market.marketapplicationdemo.entity.PaymentList;
import uz.market.marketapplicationdemo.repository.PaymentListRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentListService {
    private final PaymentListRepository paymentListRepository;

    public PaymentList create(PaymentList paymentList){
        return paymentListRepository.save(paymentList);
    }
    public PaymentList findOne(Long id){
        Optional<PaymentList> byId = paymentListRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        return null;
    }
    public Page<PaymentList> findAll(Pageable pageable){
        Page<PaymentList> all = paymentListRepository.findAll(pageable);
        return all;
    }
    public void delete(Long id){
        paymentListRepository.deleteById(id);
    }
}
