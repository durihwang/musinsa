package org.musinsa.domain.repository;

import java.util.Optional;
import org.musinsa.domain.entity.Product;

public interface ProductCustomRepository {

    Optional<Product> findByProductNameAndOptionName(String productName, String optionName);
}
