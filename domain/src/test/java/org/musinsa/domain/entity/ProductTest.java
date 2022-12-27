package org.musinsa.domain.entity;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@Slf4j
class ProductTest {

    @Test
    void name() {
        System.out.println("true = " + true);
    }
}