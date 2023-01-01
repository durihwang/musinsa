package org.musinsa.application.service;

import java.util.List;
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
    public ResponseDto<List<FindProductResponseDto>> getProduct(String productName,
        String optionName) {

        List<Product> productList = productRepository.findByProductNameAndOptionName(productName,
                optionName)
            .orElseThrow(NotExistProductNameException::new);

        if (productList.isEmpty()) {
            throw new NotExistProductNameException();
        }

        List<FindProductResponseDto> findProductResponseDtoList = FindProductResponseDto.createListFromEntityList(
            productList);

        return new ResponseDto<>(findProductResponseDtoList);
    }
}
