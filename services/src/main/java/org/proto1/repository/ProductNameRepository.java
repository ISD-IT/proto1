package org.proto1.repository;

import java.util.List;

import org.proto1.domain.product.ProductName;
import org.springframework.data.repository.CrudRepository;

public interface ProductNameRepository extends CrudRepository<ProductName, Long>{
	List<ProductName> findByProductId(Long productId);

}
