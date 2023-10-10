package net.software.Backend.service;

import net.software.Backend.error.ProductNotFoundException;
import net.software.Backend.model.Product;
import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> getAll();

    Product getById(String id) throws ProductNotFoundException;
    String deleteById(String id);
}
