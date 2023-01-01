package org.musinsa.application.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.musinsa.application.dto.ResponseDto;
import org.musinsa.application.dto.UpdateProductRequestDto;
import org.musinsa.application.dto.UpdateProductResponseDto;
import org.musinsa.domain.entity.Product;
import org.musinsa.domain.repository.ProductCustomRepository;
import org.musinsa.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@ActiveProfiles({"domain", "h2db"})
@Slf4j
//@Sql("/data/data.sql")
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    @Test
    @DisplayName("증가 동시성 테스트")
    @Transactional
    void increaseTest() throws InterruptedException {

        int numberOfThreads = 10;
        int finalQuantity = 50;
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                UpdateProductRequestDto build = getUpdateProductRequestDto(5);
                productService.increaseProduct(build);
                latch.countDown();
            });
        }
        latch.await();

        Product findProduct = productRepository.findTopByProductNameAndOptionName(
            "prd-a", "opt-aa");

        Assertions.assertThat(findProduct.getQuantity()).isEqualTo(finalQuantity);

    }

    @Test
    @DisplayName("감소 동시성 테스트")
    @Transactional
    void decreaseTest() throws InterruptedException {

        // 최초 50개 설정
        UpdateProductRequestDto build = getUpdateProductRequestDto(50);
        productService.increaseProduct(build);

        int numberOfThreads = 10;
        int finalQuantity = 0;
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                UpdateProductRequestDto updateProductRequestDto = getUpdateProductRequestDto(5);
                productService.decreaseProduct(updateProductRequestDto);
                latch.countDown();
            });
        }
        latch.await();

        Product findProduct = productRepository.findTopByProductNameAndOptionName(
            "prd-a", "opt-aa");

        Assertions.assertThat(findProduct.getQuantity()).isEqualTo(finalQuantity);

    }

    private static UpdateProductRequestDto getUpdateProductRequestDto(int quantity) {
        UpdateProductRequestDto build = UpdateProductRequestDto.builder()
            .productName("prd-a")
            .optionName("opt-aa")
            .quantity(quantity)
            .build();
        return build;
    }
}