package com.smile.model;

import java.io.Serializable;
import org.neo4j.ogm.annotation.GraphId;

public abstract class BaseNode implements Serializable {

    private static final long serialVersionUID = -4326633668365354990L;
    @GraphId
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }

        final BaseNode otherEntity = (BaseNode) other;
        if (getId() == null) {
            if (otherEntity.getId() != null) {
                return false;
            }
        } else if (!getId().equals(otherEntity.getId())) {
            return false;
        }

        return true;
    }

}
