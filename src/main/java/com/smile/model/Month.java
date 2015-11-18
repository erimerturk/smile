package com.smile.model;

import com.smile.model.relation.Relations;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Month extends BaseNode {

    private int value;

    @Relationship(type = Relations.YEAR)
    private Year year;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
}
