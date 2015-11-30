package com.smile.repository.relation;

import com.smile.model.relation.SessionProductOrder;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface SessionProductOrderRepository extends GraphRepository<SessionProductOrder> {

    @Query(
        "merge (buyer:Buyer { externalId: {2} } ) " +
        "merge (session:Session { hasc: {1} } ) " +
        "merge session-[:buyer_session]->buyer " +
        "merge (product:Product {externalId: {0} }) " +
        "create session-[r:ordered {date: timestamp()}]->product " +
        "return r"
    )
    SessionProductOrder save(long productId, String session, long buyerId);

}
