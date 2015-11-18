package com.smile.builder;

import com.smile.model.Product;
import com.smile.model.Session;
import com.smile.model.relation.SessionProductClick;
import java.util.Date;

public class SessionProductClickBuilder extends BaseBuilder<SessionProductClick, SessionProductClickBuilder> {

    private Session session;
    private Product product;
    private Date date = new Date();

    @Override
    protected SessionProductClick doBuild() {
        final SessionProductClick click = new SessionProductClick();
        click.setSession(session);
        click.setDate(date);
        click.setProduct(product);
        return click;
    }

    public SessionProductClickBuilder session(Session session) {
        this.session = session;
        return this;
    }

    public SessionProductClickBuilder product(Product product) {
        this.product = product;
        return this;
    }

    public SessionProductClickBuilder date(Date date) {
        this.date = date;
        return this;
    }
}
