package com.smile.model;

import com.google.common.collect.Lists;
import com.smile.model.relation.Relations;
import java.util.Date;
import java.util.List;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

@NodeEntity
public class Order extends BaseExternalNode {

    @Relationship(type = Relations.ORDERED)
    private Buyer belongsTo;

    @Relationship(type = Relations.ORDER_ITEM)
    private List<Product> items = Lists.newArrayList();

    @DateLong
    private Date date;

    private String session;

    public Buyer getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(Buyer belongsTo) {
        this.belongsTo = belongsTo;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
