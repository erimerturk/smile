package com.smile.builder;

import com.smile.model.Product;
import org.apache.commons.lang.math.RandomUtils;

public class ProductBuilder extends BaseBuilder<Product, ProductBuilder> {

    private Long externalId = RandomUtils.nextLong();

    @Override
    protected Product doBuild() {
        final Product product = new Product();
        product.setExternalId(externalId);
        return product;
    }

    public ProductBuilder externalId(Long externalId) {
        this.externalId = externalId;
        return this;
    }
}
