package com.pedro.api.shopping.shopping_api.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.pedro.api.shopping.shopping_api.models.dto.ShopDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    
    @Id
    public String id;

    @Field("user_identifier")
    public String userIdentifier;

    @Field("date")
    public LocalDateTime date;

    @Field("items")
    public List<Item> items;

    public Integer total;

    public static Shop convertToEntity(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setItems(shopDTO.getItems().stream().map(Item::convertToEntity).toList());
        shop.setTotal(shopDTO.getTotal());

        return shop;
    }
}
