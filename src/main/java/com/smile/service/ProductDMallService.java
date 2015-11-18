package com.smile.service;

import com.google.common.collect.Maps;
import com.smile.model.Product;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class ProductDMallService {

    private Map<Long, Product> products = Maps.newHashMap();

    @PostConstruct
    public void init(){
        final Product product = new Product();
        product.setExternalId(1L);
        products.put(1L, product);

        final Product product2 = new Product();
        product2.setExternalId(2L);
        products.put(2L, product2);


    }

    public Product getBy(Long productId) {
        return products.get(productId);
    }
}
