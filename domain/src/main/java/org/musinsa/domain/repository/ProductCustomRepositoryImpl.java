package org.musinsa.domain.repository;

import static org.musinsa.domain.entity.QProduct.product;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.musinsa.domain.entity.Product;
import org.musinsa.domain.entity.QProduct;

public class ProductCustomRepositoryImpl implements ProductCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public ProductCustomRepositoryImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<Product> findByProductNameAndOptionName(String productName, String optionName) {
        return Optional.ofNullable(
            jpaQueryFactory
                .selectFrom(product)
                .where(product.productName.eq(productName))
                .where(product.optionName.eq(optionName))
                .limit(1)
                .fetchOne()
        );
    }

}
