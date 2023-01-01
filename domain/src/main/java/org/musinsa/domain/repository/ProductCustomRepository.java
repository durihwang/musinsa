package org.musinsa.domain.repository;

import java.util.List;
import java.util.Optional;
import org.musinsa.domain.entity.Product;

public interface ProductCustomRepository {

    Optional<List<Product>> findByProductNameAndOptionName(String productName, String optionName);
}
