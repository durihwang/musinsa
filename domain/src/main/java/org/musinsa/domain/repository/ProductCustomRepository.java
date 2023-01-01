package org.musinsa.domain.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.LockModeType;
import org.musinsa.domain.entity.Product;
import org.springframework.data.jpa.repository.Lock;

public interface ProductCustomRepository {

    Optional<List<Product>> findByProductNameAndOptionName(String productName, String optionName);
}
