package org.musinsa.application.dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import org.musinsa.domain.entity.Product;

@Getter
@Builder
public class FindProductResponseDto {

    private String productName;
    private String optionName;
    private int quantity;

    public static List<FindProductResponseDto> createListFromEntityList(List<Product> productList) {
        return productList.stream()
            .map(product -> FindProductResponseDto.builder()
                .productName(product.getProductName())
                .optionName(product.getOptionName())
                .quantity(product.getQuantity())
                .build())
            .collect(Collectors.toList());
    }
}
