package uz.market.marketapplicationdemo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import uz.market.marketapplicationdemo.entity.MarketBase;
import uz.market.marketapplicationdemo.entity.PaymentList;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PaymentParamResults {
    private Long paymentId;
    private String paymentName;
    private Integer quantity;
    private BigDecimal current_price;
    private BigDecimal sum;

    public PaymentParamResults(PaymentList paymentList, MarketBase marketBase) {
        this.paymentId = paymentList.getProduct().getId();
        this.paymentName = paymentList.getProduct().getName();
        this.quantity=paymentList.getQuantity();
        this.current_price = marketBase.getCurrent_price();
        this.sum=marketBase.getCurrent_price().multiply(new BigDecimal(""+paymentList.getQuantity()));
    }

    public PaymentParamResults(MarketBase marketBase) {
        this.paymentId = marketBase.getProduct().getId();
        this.paymentName = marketBase.getProduct().getName();
        this.quantity=marketBase.getQuantity();
        this.current_price = marketBase.getCurrent_price();
        this.sum=marketBase.getCurrent_price();
    }
}
