package com.smile.builder;

import com.smile.model.BaseNode;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.template.Neo4jOperations;

public abstract class BaseBuilder<T extends BaseNode, B extends BaseBuilder<T, B>> {

    private Long id;

    @SuppressWarnings("unchecked")
    public B id(Long id) {
        this.id = id;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public Long getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    public T persist(Neo4jOperations repository) {
        T toPersist = build();
        return (T) repository.save(toPersist);
    }

    public T persist(GraphRepository<T> repository) {
        T toPersist = build();
        return (T) repository.save(toPersist);
    }

    public T build() {
        T baseEntity = doBuild();
        baseEntity.setId(id);
        return baseEntity;
    }

//    public T buildWithId() {
//        T baseEntity = doBuild();
//        baseEntity.setId(RandomUtils.nextLong(1, 1000000));
//        return baseEntity;
//    }

    protected abstract T doBuild();

}
