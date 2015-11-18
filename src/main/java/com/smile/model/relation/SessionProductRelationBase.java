package com.smile.model.relation;

import com.smile.model.BaseNode;
import com.smile.model.Product;
import com.smile.model.Session;
import java.util.Date;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

public abstract class SessionProductRelationBase extends BaseNode {

    @StartNode
    private Session session;

    @EndNode
    private Product product;

    @DateLong
    private Date date;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
