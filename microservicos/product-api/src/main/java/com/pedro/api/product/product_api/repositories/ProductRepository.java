package com.pedro.api.product.product_api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedro.api.product.product_api.models.Category;
import com.pedro.api.product.product_api.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    
    List<Product> findByCategory(Category category);
    Product findByProductIdentifier(String productIdentifier);
}
