package com.smile.model;

import com.smile.model.relation.Relations;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Session extends BaseNode {

    private String hasc;

    @Relationship(type = Relations.PERSISTENT_INFO)
    private Persistent persistent;

    @Relationship(type = Relations.BUYER_SESSION)
    private Buyer buyer;

    public String getHasc() {
        return hasc;
    }

    public void setHasc(String hasc) {
        this.hasc = hasc;
    }

    public Persistent getPersistent() {
        return persistent;
    }

    public void setPersistent(Persistent persistent) {
        this.persistent = persistent;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
