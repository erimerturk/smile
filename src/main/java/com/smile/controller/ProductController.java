package com.smile.controller;

import com.smile.conf.RequestMappings;
import com.smile.dto.SessionProductClickDto;
import com.smile.model.Product;
import com.smile.model.relation.SessionProductClick;
import com.smile.model.relation.SessionProductOrder;
import com.smile.service.ProductService;
import com.smile.service.relation.SessionProductClickService;
import com.smile.service.relation.SessionProductOrderService;
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

    @Autowired
    private SessionProductOrderService sessionProductOrderService;

    @RequestMapping(value = RequestMappings.CLICK, method = RequestMethod.POST)
    public SessionProductClick click(@RequestBody SessionProductClickDto req) {
        final Product product = productService.findByExternalId(req.getProductId());
        return sessionProductClickService.save(product, req.getSession());
    }

    @RequestMapping(value = RequestMappings.ORDER, method = RequestMethod.POST)
    public SessionProductOrder order(@RequestBody SessionProductClickDto req) {
        final Product product = productService.findByExternalId(req.getProductId());
        return sessionProductOrderService.save(product, req.getSession(), req.getBuyerId());
    }

}
