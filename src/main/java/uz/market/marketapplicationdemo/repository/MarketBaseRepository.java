package uz.market.marketapplicationdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.market.marketapplicationdemo.entity.MarketBase;
import uz.market.marketapplicationdemo.entity.dto.PaymentParamResults;

@Repository
public interface MarketBaseRepository extends JpaRepository<MarketBase,Long> {
    MarketBase findTopByProductCode(String code);

    @Query("select new uz.market.marketapplicationdemo.entity.dto.PaymentParamResults(m) " +
            "from MarketBase m where m.product.code=:code")
    PaymentParamResults findByProductCode(@Param("code") String code);
}
