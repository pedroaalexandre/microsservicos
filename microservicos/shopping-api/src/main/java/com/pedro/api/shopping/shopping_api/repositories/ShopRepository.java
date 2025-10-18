package com.pedro.api.shopping.shopping_api.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedro.api.shopping.shopping_api.models.Shop;


public interface ShopRepository extends MongoRepository <Shop, String>{
    List<Shop> queryByUserIdentifierLike(String userIdentifier);
    List<Shop> queryByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Shop> findByItems_ProductIdentifier(String productIdentifier);
    List<Shop> findByDateBetweenAndTotalGreaterThanEqual(
        LocalDateTime startDate, 
        LocalDateTime endDate, 
        Integer minValue
    );
}
