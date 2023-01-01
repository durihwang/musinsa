package org.musinsa.application.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.musinsa.application.dto.FindProductResponseDto;
import org.musinsa.application.dto.ResponseDto;
import org.musinsa.application.dto.UpdateProductRequestDto;
import org.musinsa.application.dto.UpdateProductResponseDto;
import org.musinsa.application.exception.NotExistProductNameException;
import org.musinsa.application.exception.QuantityException;
import org.musinsa.domain.entity.Product;
import org.musinsa.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
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

    @Override
    @Transactional
    public ResponseDto<UpdateProductResponseDto> increaseProduct(
        UpdateProductRequestDto updateProductRequestDto) {

        Product findProduct = productRepository.findTopByProductNameAndOptionName(
            updateProductRequestDto.getProductName(),
            updateProductRequestDto.getOptionName()).orElseThrow(NotExistProductNameException::new);

        AtomicInteger atomicInteger = new AtomicInteger(
            findProduct.getQuantity() + updateProductRequestDto.getQuantity());

        findProduct.changeQuantity(atomicInteger);

        return new ResponseDto<>(UpdateProductResponseDto.createDto(findProduct));
    }

    @Override
    @Transactional()
    public ResponseDto<UpdateProductResponseDto> decreaseProduct(
        UpdateProductRequestDto updateProductRequestDto) {

        Product findProduct = productRepository.findTopByProductNameAndOptionName(
            updateProductRequestDto.getProductName(),
            updateProductRequestDto.getOptionName()).orElseThrow(NotExistProductNameException::new);

        AtomicInteger atomicInteger = new AtomicInteger(
            findProduct.getQuantity() - updateProductRequestDto.getQuantity());

        log.info(String.valueOf(findProduct.getQuantity()));
        log.info(String.valueOf(updateProductRequestDto.getQuantity()));

        if (atomicInteger.get() < 0) {
            throw new QuantityException();
        }

        findProduct.changeQuantity(atomicInteger);

        return new ResponseDto<>(UpdateProductResponseDto.createDto(findProduct));
    }
}
