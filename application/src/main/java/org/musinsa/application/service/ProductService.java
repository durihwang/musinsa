package org.musinsa.application.service;

import org.musinsa.application.dto.FindProductResponseDto;
import org.musinsa.application.dto.ResponseDto;

public interface ProductService {

    ResponseDto<FindProductResponseDto> getProduct(String productName, String optionName);

}
