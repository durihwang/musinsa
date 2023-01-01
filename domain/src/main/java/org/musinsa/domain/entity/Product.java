package org.musinsa.domain.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
public class Product {

    @Id
    private Long id;

    private String productName;

    private String optionName;

    private int quantity;
}
