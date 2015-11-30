package com.smile.model;

import com.smile.model.relation.Relations;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Persistent extends BaseNode {

    private String hapc;

    @Relationship(type = Relations.BUYER_PERSISTENT)
    private Buyer buyer;

    public String getHapc() {
        return hapc;
    }

    public void setHapc(String hapc) {
        this.hapc = hapc;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
