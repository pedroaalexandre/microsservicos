package com.pedro.api.shopping.shopping_api.models.dto;

import org.springframework.data.mongodb.core.mapping.Field;

import com.pedro.api.shopping.shopping_api.models.Item;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    @Field("product_identifier")
    public String productIdentifier;

    @Positive
    public Double price;

    public static ItemDTO convertToDTO (Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }
}
