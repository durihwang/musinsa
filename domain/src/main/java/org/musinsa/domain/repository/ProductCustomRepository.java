package org.musinsa.domain.repository;

import com.querydsl.jpa.impl.JPAUpdateClause;
import java.util.List;
import java.util.Optional;
import org.musinsa.domain.entity.Product;

public interface ProductCustomRepository {

    Optional<List<Product>> findByProductNameAndOptionName(String productName, String optionName);

    JPAUpdateClause updateProductByProductNameAndOptionName(String productName, String optionName,
        int quantity);
}
