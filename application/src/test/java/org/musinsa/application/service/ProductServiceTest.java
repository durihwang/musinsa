package org.musinsa.application.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.musinsa.application.dto.UpdateProductRequestDto;
import org.musinsa.application.exception.QuantityException;
import org.musinsa.domain.entity.Product;
import org.musinsa.domain.entity.Product.ProductBuilder;
import org.musinsa.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@ActiveProfiles({"domain"})
@Slf4j
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    private EntityManager em;

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
    @DisplayName("수량 마이너스 체크")
    @Transactional
    void decreaseTest() throws PessimisticLockingFailureException, InterruptedException {

        assertThrows(QuantityException.class, () -> {
            UpdateProductRequestDto updateProductRequestDto = getUpdateProductRequestDto(5);
            productService.decreaseProduct(updateProductRequestDto);
        });
    }

    private static UpdateProductRequestDto getUpdateProductRequestDto(int quantity) {
        return UpdateProductRequestDto.builder()
            .productName("prd-a")
            .optionName("opt-aa")
            .quantity(quantity)
            .build();
    }
}