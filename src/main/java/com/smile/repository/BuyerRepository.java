package com.smile.repository;

import com.smile.model.Buyer;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface BuyerRepository extends GraphRepository<Buyer> {

    Buyer findByExternalId(Long buyerId);
}
