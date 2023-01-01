package org.musinsa.application.service;

import java.util.List;
import org.musinsa.application.dto.FindProductResponseDto;
import org.musinsa.application.dto.ResponseDto;
import org.musinsa.application.dto.UpdateProductRequestDto;
import org.musinsa.application.dto.UpdateProductResponseDto;

public interface ProductService {

    ResponseDto<List<FindProductResponseDto>> getProduct(String productName, String optionName);

    ResponseDto<UpdateProductResponseDto> increaseProduct(
        UpdateProductRequestDto updateProductRequestDto);

    ResponseDto<UpdateProductResponseDto> decreaseProduct(
        UpdateProductRequestDto updateProductRequestDto);

}
