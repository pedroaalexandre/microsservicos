package com.pedro.api.shopping.shopping_api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.pedro.api.shopping.shopping_api.models.dto.ItemDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    
    @Id
    @Field("product_identifier")
    public String productIdentifier;

    @Field("price")
    public Double price;

    public static Item convertToEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductIdentifier(itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());
        return item;
    }
}
