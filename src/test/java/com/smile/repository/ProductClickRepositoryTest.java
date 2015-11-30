package com.smile.repository;

import com.smile.builder.MonthBuilder;
import com.smile.config.BaseIntegration;
import com.smile.model.Month;
import com.smile.model.ProductClick;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class ProductClickRepositoryTest extends BaseIntegration {

    @Autowired
    private ProductClickRepository repository;

    @Test
    public void shouldSaveClick() {

        final Month month = new MonthBuilder().persist(getNeo4jTemplate());

        final ProductClick persisted = repository.save(1L, "abc", month);


        final ProductClick fromNEO = repository.findOne(persisted.getId());

        assertThat(persisted, not(nullValue()));
    }
}