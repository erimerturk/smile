package com.smile.service;

import com.google.common.collect.Maps;
import com.smile.model.Buyer;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class BuyerDMallService {

    private Map<Long, Buyer> buyers = Maps.newHashMap();

    @PostConstruct
    public void init(){
        final Buyer buyer = new Buyer();
        buyer.setExternalId(1L);
        buyer.setEmail("buyer1@mail.com");
        buyer.setName("buyer1");

        buyers.put(1L, buyer);

        final Buyer buyer2 = new Buyer();
        buyer2.setExternalId(2L);
        buyer2.setEmail("buyer2@mail.com");
        buyer2.setName("buyer2");

        buyers.put(2L, buyer2);

    }

    public Buyer getBy(Long buyerId) {
        return buyers.get(buyerId);
    }
}
