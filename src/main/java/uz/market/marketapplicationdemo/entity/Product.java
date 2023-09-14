package uz.market.marketapplicationdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.market.marketapplicationdemo.entity.enums.ProductType;
import uz.market.marketapplicationdemo.entity.enums.Status;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_market")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    @Enumerated(EnumType.STRING)
    private ProductType type;
    @Enumerated(EnumType.STRING)
    private Status status;

}
