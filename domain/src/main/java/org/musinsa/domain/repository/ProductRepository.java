package org.musinsa.domain.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.LockModeType;
import javax.persistence.Version;
import org.hibernate.annotations.OptimisticLocking;
import org.musinsa.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductCustomRepository {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Product findTopByProductNameAndOptionName(String productName, String optionName);

}
