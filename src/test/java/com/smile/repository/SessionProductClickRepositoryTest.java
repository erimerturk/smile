package com.smile.repository;

import com.smile.config.BaseIntegration;
import com.smile.model.Product;
import com.smile.model.relation.SessionProductClick;
import com.smile.repository.relation.SessionProductClickRepository;
import java.util.List;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class SessionProductClickRepositoryTest extends BaseIntegration {

    @Autowired
    private SessionProductClickRepository repository;

    @Test
    public void shouldFindProductsBySessionId() {

        String session1Id = RandomStringUtils.randomAlphabetic(12);
        String session2Id = RandomStringUtils.randomAlphabetic(12);

        final long product3Id = RandomUtils.nextLong();
        final long product4Id = RandomUtils.nextLong();
        final long product5Id = RandomUtils.nextLong();


        final SessionProductClick click1 = repository.save(product3Id, session1Id);
        final SessionProductClick click2 = repository.save(product4Id, session1Id);
        final SessionProductClick click21 = repository.save(product4Id, session1Id);

        final SessionProductClick click3 = repository.save(product5Id, session2Id);

        final List<Product> bySessionId = repository.findAllProductBy(session1Id);

        assertThat(bySessionId, hasSize(2));
        assertThat(bySessionId, hasItems(click1.getProduct(), click2.getProduct()));

    }

    @Test
    public void shouldFindClickBySessionId() {

        String session1Id = RandomStringUtils.randomAlphabetic(12);
        String session2Id = RandomStringUtils.randomAlphabetic(12);

        final long product3Id = RandomUtils.nextLong();
        final long product4Id = RandomUtils.nextLong();
        final long product5Id = RandomUtils.nextLong();


        final SessionProductClick click1 = repository.save(product3Id, session1Id);
        final SessionProductClick click2 = repository.save(product4Id, session1Id);
        final SessionProductClick click21 = repository.save(product4Id, session1Id);

        final SessionProductClick click3 = repository.save(product5Id, session2Id);

        final List<SessionProductClick> bySessionId = repository.findAllClickBy(session1Id);

        assertThat(bySessionId, hasSize(3));
        assertThat(bySessionId, hasItems(click1, click2, click21));

    }
}