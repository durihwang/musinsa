package org.musinsa.application.dto;

import lombok.Builder;
import lombok.Getter;
import org.musinsa.domain.entity.Product;

@Getter
@Builder
public class FindProductResponseDto {

    private String productName;
    private String optionName;
    private int quantity;

    public static FindProductResponseDto createDtoFromEntity(Product product) {
        return FindProductResponseDto.builder()
            .optionName(product.getOptionName())
            .productName(product.getProductName())
            .quantity(product.getQuantity())
            .build();
    }
}
