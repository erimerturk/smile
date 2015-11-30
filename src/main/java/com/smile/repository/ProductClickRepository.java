package com.smile.repository;

import com.smile.model.Month;
import com.smile.model.ProductClick;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface ProductClickRepository extends GraphRepository<ProductClick> {

    @Query(
        "start month= node({2}) " +
        "create (pc:ProductClick {when: timestamp()} ) " +
        "merge (session:Session { hasc: {1} } ) " +
        "merge (product:Product {externalId: {0} }) " +
        "create pc-[:pcs]->session " +
        "create pc-[:click]->product " +
        "create pc-[:month]-> month " +
        "return pc"
    )
    ProductClick save(long productId, String session, Month month);

}
