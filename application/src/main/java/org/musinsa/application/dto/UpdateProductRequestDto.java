package org.musinsa.application.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequestDto {

    @NotNull
    private String productName;
    @NotNull
    private String optionName;
    @Positive
    private int quantity;

}
