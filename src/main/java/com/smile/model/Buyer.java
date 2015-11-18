package com.smile.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Buyer extends BaseExternalNode {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
