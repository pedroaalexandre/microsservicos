package com.pedro.api.shopping.shopping_api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedro.api.shopping.shopping_api.models.Item;


public interface ItemRepository extends MongoRepository <Item, String>{
    Item findByProductIdentifier(String product_identifier);
}
