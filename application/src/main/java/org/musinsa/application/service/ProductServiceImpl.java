package org.musinsa.application.service;

import lombok.RequiredArgsConstructor;
import org.musinsa.application.dto.FindProductResponseDto;
import org.musinsa.application.dto.ResponseDto;
import org.musinsa.application.exception.NotExistProductNameException;
import org.musinsa.domain.entity.Product;
import org.musinsa.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ResponseDto<FindProductResponseDto> getProduct(String productName, String optionName) {

        Product product = productRepository.findByProductNameAndOptionName("prd-a", "opt-aa")
            .orElseThrow(NotExistProductNameException::new);

        FindProductResponseDto findProductResponseDto = FindProductResponseDto.createDtoFromEntity(
            product);

        return new ResponseDto<>(findProductResponseDto);
    }
}
