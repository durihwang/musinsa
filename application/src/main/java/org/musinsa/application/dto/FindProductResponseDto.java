package org.musinsa.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindProductResponseDto {

    private String productName;
    private String optionName;
    private int quantity;
}
