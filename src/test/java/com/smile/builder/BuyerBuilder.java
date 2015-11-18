package com.smile.builder;

import com.smile.model.Buyer;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

public class BuyerBuilder extends BaseBuilder<Buyer, BuyerBuilder> {

    private String name = RandomStringUtils.random(10);
    private String email = RandomStringUtils.random(10);
    private Long externalId = RandomUtils.nextLong();

    @Override
    protected Buyer doBuild() {
        final Buyer buyer = new Buyer();
        buyer.setEmail(email);
        buyer.setName(name);
        buyer.setExternalId(externalId);
        return buyer;
    }

    public BuyerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BuyerBuilder email(String email) {
        this.email = email;
        return this;
    }

    public BuyerBuilder externalId(Long externalId) {
        this.externalId = externalId;
        return this;
    }
}
