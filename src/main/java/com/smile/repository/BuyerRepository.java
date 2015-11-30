package com.smile.repository;

import com.smile.model.Buyer;
import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface BuyerRepository extends GraphRepository<Buyer> {

    Buyer findByExternalId(Long buyerId);


    @Query(
        "match (session:Session)-[:ordered]->(product:Product {externalId: {0} } ) " +
        "match session-[:ordered]->(otherP:Product)<-[:ordered]-(targets:Session) " +
        "where otherP.externalId <> {0} AND NOT (targets-[:ordered]->product) " +
        "with targets, count(targets) as oCount " +
        "order by oCount desc " +
        "match targets-[:buyer_session]->(buyer:Buyer)" +
        "return buyer "
    )
    List<Buyer> whoBuysBasedOnSession(Long productID);

//    @Query(
//        "match (product:Product {externalId: {0} } )-[:order_item]->(order:Order) " +
////        "match order-[:order_item]->(otherP:Product)<-[:order_item]-(targets:Order) " +
////        "where otherP.externalId <> {0} AND NOT (targets-[:order_item]->product) " +
////        "with targets, count(targets) as oCount " +
////        "order by oCount desc " +
////        "match targets-[:ordered]->(buyer:Buyer)" +
//        "return order "
//    )
//    List<Order> whoBuysBasedOnOrder(Long productID);

    @Query(
        "match (order:Order)-[:order_item]->(product:Product {externalId: {0} } ) " +
        "match order-[:order_item]->(otherP:Product)<-[:order_item]-(targets:Order) " +
        "where otherP.externalId <> {0} AND NOT (targets-[:order_item]->product) " +
        "with targets, count(targets) as oCount " +
        "order by oCount desc " +
        "match targets-[:ordered]->(buyer:Buyer)" +
        "return buyer "
    )
    List<Buyer> whoBuysBasedOnOrder(Long productID);
}
