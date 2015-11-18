package com.smile.service;

import com.smile.model.Buyer;
import com.smile.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private BuyerDMallService buyerDMallService;

    public Buyer findByExternalId(Long buyerId) {

        Buyer fromNEO = buyerRepository.findByExternalId(buyerId);

        if (fromNEO == null) {
            Buyer fromDMall = buyerDMallService.getBy(buyerId);
            fromNEO = buyerRepository.save(fromDMall);
        }
        return fromNEO;
    }
}
