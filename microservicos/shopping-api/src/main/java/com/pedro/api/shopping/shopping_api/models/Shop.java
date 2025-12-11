package com.pedro.api.shopping.shopping_api.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.pedro.dto.ShopDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    
    @Id
    private String id;

    @Field("user_identifier")
    private String userIdentifier;

    @Field("date")
    private LocalDateTime date;

    @Field("items")
    private List<Item> items;

    private Integer total;

    public static Shop convertToEntity(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setItems(shopDTO.getItems().stream().map(Item::convertToEntity).toList());
        shop.setTotal(shopDTO.getTotal());

        return shop;
    }
}
