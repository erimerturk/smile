package com.smile.controller;

import com.smile.model.Buyer;
import com.smile.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private BuyerRepository buyerRepository;

    @RequestMapping("/test")
    public Iterable<Buyer> test() {

        final Buyer entity = new Buyer();
        entity.setName("name");
        buyerRepository.save(entity);
        return buyerRepository.findAll();
    }

    @RequestMapping("/")
    public String index() {

        return "hello world";
    }

}
