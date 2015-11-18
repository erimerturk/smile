package com.smile.repository.relation;

import com.smile.model.Product;
import com.smile.model.relation.SessionProductClick;
import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface SessionProductClickRepository extends GraphRepository<SessionProductClick> {

    @Query(
        "merge (session:Session { hasc: {1} } ) " +
        "merge (product:Product {externalId: {0} }) " +
        "create session-[r:clicked {date: timestamp()}]->product " +
        "return r"
    )
    SessionProductClick save(long productId, String session);

    @Query(
        "match (session:Session { hasc: {0} } ) " +
        "match session-[r:clicked]->(product:Product) " +
        "return product"
    )
    List<Product> findAllProductBy(String session);

    @Query(
        "match (session:Session { hasc: {0} } ) " +
            "match session-[r:clicked]->(product:Product) " +
            "return r"
    )
    List<SessionProductClick> findAllClickBy(String session);
}
