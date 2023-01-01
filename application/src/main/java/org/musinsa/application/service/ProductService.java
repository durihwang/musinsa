package org.musinsa.application.service;

import java.util.List;
import org.musinsa.application.dto.FindProductResponseDto;
import org.musinsa.application.dto.ResponseDto;

public interface ProductService {

    ResponseDto<List<FindProductResponseDto>> getProduct(String productName, String optionName);

}
