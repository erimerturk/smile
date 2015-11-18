package com.smile.repository;

import com.smile.builder.BuyerBuilder;
import com.smile.config.BaseIntegration;
import com.smile.model.Buyer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class BuyerRepositoryTest extends BaseIntegration {

    @Autowired
    private BuyerRepository repository;

    @Test
    public void shouldFindBuyers() {

        final Buyer erim = new BuyerBuilder().name("erim").persist(getNeo4jTemplate());

        final Iterable<Buyer> all = repository.findAll();

        assertThat(all, hasItem(erim));
    }
}