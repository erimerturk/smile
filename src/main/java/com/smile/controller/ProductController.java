package com.smile.controller;

import com.smile.dto.SessionProductClickDto;
import com.smile.model.Product;
import com.smile.model.relation.SessionProductClick;
import com.smile.service.ProductService;
import com.smile.service.relation.SessionProductClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SessionProductClickService sessionProductClickService;

    @RequestMapping(value = "/click", method = RequestMethod.POST)
    public SessionProductClick click(@RequestBody SessionProductClickDto req) {
        final Product product = productService.findByExternalId(req.getProductId());
        return sessionProductClickService.save(product, req.getSession());
    }

}
