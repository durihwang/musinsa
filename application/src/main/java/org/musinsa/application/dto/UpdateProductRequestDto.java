package org.musinsa.application.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class UpdateProductRequestDto {

    @NotNull
    private String productName;
    @NotNull
    private String optionName;
    @Positive
    private int quantity;

}
