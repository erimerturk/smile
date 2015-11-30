package com.smile.service.relation;

import com.smile.model.Product;
import com.smile.model.relation.SessionProductClick;
import com.smile.repository.relation.SessionProductClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionProductClickService {

    @Autowired
    private SessionProductClickRepository repository;

    public SessionProductClick save(Product product, String session){
        return repository.save(product.getExternalId(), session);
    }

}
