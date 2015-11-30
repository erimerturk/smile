package com.smile.service.relation;

import com.smile.model.Product;
import com.smile.model.relation.SessionProductOrder;
import com.smile.repository.relation.SessionProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SessionProductOrderService {

    @Autowired
    private SessionProductOrderRepository repository;

    @Transactional
    public SessionProductOrder save(Product product, String session, long buyer){
        return repository.save(product.getExternalId(), session, buyer);
    }

}
