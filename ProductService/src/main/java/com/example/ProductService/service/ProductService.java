package com.example.ProductService.service;

import com.example.ProductService.model.ProductRequest;
import com.example.ProductService.model.ProductResponse;
import org.springframework.stereotype.Service;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getById(long id);
}
