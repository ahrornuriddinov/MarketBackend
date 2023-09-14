package uz.market.marketapplicationdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.market.marketapplicationdemo.entity.PaymentList;
@Repository
public interface PaymentListRepository extends JpaRepository<PaymentList,Long> {

}
