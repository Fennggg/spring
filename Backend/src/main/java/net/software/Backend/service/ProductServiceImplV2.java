package net.software.Backend.service;

import net.software.Backend.entity.ProductEntity;
import net.software.Backend.error.ProductNotFoundException;
import net.software.Backend.model.Product;
import net.software.Backend.repositary.ProductRepositary;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplV2 implements ProductService{
    @Autowired
    private ProductRepositary productRepositary;
    @Override
    public Product save(Product product) {
        if(product.getProductId() == null){
            product.setProductId((UUID.randomUUID().toString()));
        }
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        productRepositary.save(productEntity);
        return null;
    }

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productEntityList = productRepositary.findAll();
        //deepcopy product list
        List<Product> productList = productEntityList.stream()
                .map(productEntity -> {
                    Product product = new Product();
                    BeanUtils.copyProperties((productEntity), product);
                    return product;
                }).collect(Collectors.toList());
        return productList;
    }

    @Override
    public Product getById(String id) throws ProductNotFoundException {
        ProductEntity productEntity = productRepositary.findById(id).get();
        Product product = new Product();
        BeanUtils.copyProperties((productEntity), product);
        return product;
    }

    @Override
    public String deleteById(String id) {
        productRepositary.deleteById(id);
        return "Delete Product with id: " + id;
    }
}
