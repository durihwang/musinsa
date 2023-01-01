package org.musinsa.domain.entity;


import java.util.concurrent.atomic.AtomicInteger;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Product {

    @Id
    private Long id;

    private String productName;

    private String optionName;

    private int quantity;

    public Product() {

    }

    public void changeQuantity(AtomicInteger atomicInteger) {
        this.quantity = atomicInteger.get();
    }

}
