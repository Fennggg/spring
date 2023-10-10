package com.example.ProductService.service;

import com.example.ProductService.entity.ProductEntity;
import com.example.ProductService.model.ProductRequest;
import com.example.ProductService.model.ProductResponse;
import com.example.ProductService.repository.ProductRepository;
import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest){
        //log.info("Start: ProductService addProduct");
        ProductEntity productEntity = ProductEntity.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRepository.save(productEntity);
        //log.info("End: ProductService addProduct");
        return productEntity.getId();
    }

    @Override
    public ProductResponse getById(long id) {
        //log.info("Start: ProductService getById");
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductService getById Not Found with id"));
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(productEntity, productResponse);
        //log.info("End: ProductService getById" + productResponse);
        return null;
    }

}
