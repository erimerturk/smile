package com.smile.service;

import com.smile.model.Month;
import com.smile.model.Product;
import com.smile.model.ProductClick;
import com.smile.repository.ProductClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductClickService {

    @Autowired
    private ProductClickRepository repository;

    @Autowired
    private MonthService monthService;

    public ProductClick save(Product product, String session){

        Month month = monthService.getCurrentMonth();

        return repository.save(product.getExternalId(), session, month);
    }

}
