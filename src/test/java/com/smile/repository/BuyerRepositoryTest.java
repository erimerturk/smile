package com.smile.repository;

import com.google.common.collect.Lists;
import com.smile.builder.BuyerBuilder;
import com.smile.builder.OrderBuilder;
import com.smile.builder.ProductBuilder;
import com.smile.config.BaseIntegration;
import com.smile.model.Buyer;
import com.smile.model.Order;
import com.smile.model.Product;
import com.smile.repository.relation.SessionProductOrderRepository;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BuyerRepositoryTest extends BaseIntegration {

    @Autowired
    private BuyerRepository repository;

    @Autowired
    private SessionProductOrderRepository sessionProductOrderRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void shouldFindBuyersBasedOnSession() {

        long buyer1Id = 1L;
        long buyer2Id = 2L;
        sessionProductOrderRepository.save(1L, "B1", buyer1Id);
        sessionProductOrderRepository.save(2L, "B1", buyer1Id);

        sessionProductOrderRepository.save(3L, "B1", buyer1Id);


        sessionProductOrderRepository.save(1L, "B2", buyer2Id);
        sessionProductOrderRepository.save(2L, "B2", buyer2Id);
        sessionProductOrderRepository.save(6L, "B2", buyer2Id);


        sessionProductOrderRepository.save(1L, "target1", 3L);
        sessionProductOrderRepository.save(3L, "target1", 3L);

        sessionProductOrderRepository.save(1L, "target2", 4L);

        sessionProductOrderRepository.save(6L, "target3", 5L);
        sessionProductOrderRepository.save(1L, "target3", 5L);
        sessionProductOrderRepository.save(3L, "target3", 5L);



        final List<Buyer> buyers = repository.whoBuysBasedOnSession(2L);

        final List<Long> result = buyers.stream().map(Buyer::getExternalId).collect(toList());
        assertThat(result, equalTo(Lists.newArrayList(5L, 3L, 4L)));

    }

    @Test
    public void shouldFindBuyersBasedOnOrder() {

        final Buyer buyer1 = new BuyerBuilder().externalId(1L).persist(getNeo4jTemplate());
        final Buyer buyer2 = new BuyerBuilder().externalId(2L).persist(getNeo4jTemplate());

        final Buyer buyer3 = new BuyerBuilder().externalId(3L).persist(getNeo4jTemplate());
        final Buyer buyer4 = new BuyerBuilder().externalId(4L).persist(getNeo4jTemplate());
        final Buyer buyer5 = new BuyerBuilder().externalId(5L).persist(getNeo4jTemplate());

        final Product product1 = new ProductBuilder().externalId(1L).persist(getNeo4jTemplate());
        final Product product2 = new ProductBuilder().externalId(2L).persist(getNeo4jTemplate());
        final Product product3 = new ProductBuilder().externalId(3L).persist(getNeo4jTemplate());
        final Product product6 = new ProductBuilder().externalId(6L).persist(getNeo4jTemplate());


        final Order order1 = new OrderBuilder().belongsTo(buyer1).item(product1).item(product2).item(product3).orderNumber("b1").persist(getNeo4jTemplate());

        final Order order2 = new OrderBuilder().belongsTo(buyer2).item(product1).item(product2).item(product6).orderNumber("b2").persist(getNeo4jTemplate());

        final Order order3 = new OrderBuilder().belongsTo(buyer3).item(product1).item(product3).orderNumber("target1").persist(getNeo4jTemplate());

        final Order order4 = new OrderBuilder().belongsTo(buyer4).item(product1).orderNumber("target2").persist(getNeo4jTemplate());

        final Order order5 = new OrderBuilder().belongsTo(buyer5).item(product1).item(product6).item(product3).orderNumber("target3").persist(getNeo4jTemplate());

        final List<Buyer> buyers = repository.whoBuysBasedOnOrder(2L);

        final List<Long> result = buyers.stream().map(Buyer::getExternalId).collect(toList());
        assertThat(result, equalTo(Lists.newArrayList(5L, 3L, 4L)));

    }
}