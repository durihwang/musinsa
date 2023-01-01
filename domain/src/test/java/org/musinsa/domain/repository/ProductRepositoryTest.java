package org.musinsa.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.musinsa.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql("/data/data.sql")
@ActiveProfiles({"domain", "h2db"})
class ProductRepositoryTest {


    @Autowired
    ProductRepository productRepository;

    @Test
    void findProductTest() {
        Product products = productRepository.findTopByProductNameAndOptionName("prd-a", "opt-aa");

        assertThat(products.getProductName()).isEqualTo("prd-a");
    }
}