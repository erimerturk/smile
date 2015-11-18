package com.smile.repository;

import com.smile.model.Product;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface ProductRepository extends GraphRepository<Product> {
    Product findByExternalId(Long productId);
}
