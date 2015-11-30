package com.smile.builder;

import com.google.common.collect.Lists;
import com.smile.model.Buyer;
import com.smile.model.Order;
import com.smile.model.Product;
import java.util.Date;
import java.util.List;

public class OrderBuilder extends BaseBuilder<Order, OrderBuilder> {

    private Buyer belongsTo;

    private List<Product> items = Lists.newArrayList();
    private Date date;
    private String orderNumber;

    @Override
    protected Order doBuild() {

        final Order order = new Order();
        order.setBelongsTo(belongsTo);
        order.setDate(date);
        order.setItems(items);
        order.setOrderNumber(orderNumber);
        return order;
    }

    public OrderBuilder belongsTo(Buyer belongsTo) {
        this.belongsTo = belongsTo;
        return this;
    }

    public OrderBuilder items(List<Product> items) {
        this.items = items;
        return this;
    }

    public OrderBuilder item(Product item) {
        items.add(item);
        return this;
    }

    public OrderBuilder date(Date date) {
        this.date = date;
        return this;
    }

    public OrderBuilder orderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }
}
