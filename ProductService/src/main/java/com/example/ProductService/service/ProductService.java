package com.example.ProductService.service;

import com.example.ProductService.model.ProductRequest;
import org.springframework.stereotype.Service;

public interface ProductService {
    long addProduct(ProductRequest productRequest);
}
