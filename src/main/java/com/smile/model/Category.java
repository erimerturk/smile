package com.smile.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Category extends BaseExternalNode {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
