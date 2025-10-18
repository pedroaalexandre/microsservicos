package com.pedro.api.shopping.shopping_api.models.dto;

import java.util.List;


import com.pedro.api.shopping.shopping_api.models.Shop;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {

    private String id;

    @NotBlank(message = "O campo user_identifier não pode ser vazio ou nulo.")
    public String userIdentifier;

    @NotBlank(message = "O campo items não pode ser vazio ou nulo.")
    public List<ItemDTO> items;

    @PositiveOrZero(message = "O número total de itens não pode ser negativo.")
    public Integer total;

    public static ShopDTO convertToDto(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setItems(shop.getItems().stream().map(ItemDTO::convertToDTO).toList());
        shopDTO.setTotal(shop.getTotal());
        return shopDTO;
    }
}
