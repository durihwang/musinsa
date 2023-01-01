package org.musinsa.application.dto;

import lombok.Builder;
import lombok.Getter;
import org.musinsa.domain.entity.Product;

@Getter
@Builder
public class UpdateProductResponseDto {

    private String productName;
    private String optionName;
    private int quantity;

    public static UpdateProductResponseDto createDto(Product product) {
        return UpdateProductResponseDto.builder()
            .productName(product.getProductName())
            .optionName(product.getOptionName())
            .quantity(product.getQuantity())
            .build();
    }
}
