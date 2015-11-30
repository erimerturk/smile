package com.smile.model;

import com.smile.model.relation.Relations;
import java.util.Date;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

@NodeEntity
public class ProductClick extends BaseNode {

    @Relationship(type = Relations.PRODUCT_CLICK_SESSION)
    private Session session;

    @Relationship(type = Relations.PRODUCT_CLICK)
    private Product product;

    @DateLong
    private Date when;

    @Relationship(type = Relations.PRODUCT_CLICK_MONTH)
    private Month month;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
}
