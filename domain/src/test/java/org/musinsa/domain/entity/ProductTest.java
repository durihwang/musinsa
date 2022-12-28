package org.musinsa.domain.entity;

import static org.junit.jupiter.api.Assertions.*;
import static org.musinsa.domain.entity.QProduct.product;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ActiveProfiles({"domain", "h2db"})
@Slf4j
class ProductTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    @DisplayName("재고 조회 테스트")
    void productFindTest() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);

        jpaQueryFactory
            .selectFrom(product)
            .fetch().forEach(product1 -> System.out.println(
                "product1.getProductName() = " + product1.getProductName()));

    }
}