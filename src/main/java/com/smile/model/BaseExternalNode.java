package com.smile.model;

public abstract class BaseExternalNode extends BaseNode {

    private Long externalId;

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

}
