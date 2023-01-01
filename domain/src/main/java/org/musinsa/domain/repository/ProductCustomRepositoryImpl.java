package org.musinsa.domain.repository;

import static org.musinsa.domain.entity.QProduct.product;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.musinsa.domain.entity.Product;
import org.musinsa.domain.entity.QProduct;
import org.springframework.util.StringUtils;

@Slf4j
public class ProductCustomRepositoryImpl implements ProductCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public ProductCustomRepositoryImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<List<Product>> findByProductNameAndOptionName(String productName, String optionName) {
        return Optional.ofNullable(
            jpaQueryFactory
                .selectFrom(product)
                .where(product.productName.eq(productName), eqOptionName(optionName))
                .fetch()
        );
    }

    private BooleanExpression eqOptionName(String optionName) {
        if (optionName == null) {
            return null;
        }
        return product.optionName.eq(optionName);
    }

}
