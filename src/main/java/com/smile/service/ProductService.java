package com.smile.service;

import com.smile.model.Product;
import com.smile.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductDMallService productDMallService;

    public Product findByExternalId(Long productId) {

        Product fromNEO = repository.findByExternalId(productId);

        if (fromNEO == null) {
            Product fromDMall = productDMallService.getBy(productId);
            fromNEO = repository.save(fromDMall);
        }
        return fromNEO;
    }
}
