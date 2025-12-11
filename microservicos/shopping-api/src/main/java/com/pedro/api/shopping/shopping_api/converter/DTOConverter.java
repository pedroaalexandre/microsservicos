package com.pedro.api.shopping.shopping_api.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.pedro.api.shopping.shopping_api.models.Item;
import com.pedro.api.shopping.shopping_api.models.Shop;
import com.pedro.dto.ItemDTO;
import com.pedro.dto.ShopDTO;



public class DTOConverter {
    public static ShopDTO fromModel(Shop shopping) {
        List<ItemDTO> itemsDTO = shopping.getItems().stream()
                .map(DTOConverter::fromModel)
                .collect(Collectors.toList());
        return new ShopDTO(
                shopping.getId(),
                shopping.getUserIdentifier(),
                shopping.getDate(),
                itemsDTO,
                shopping.getTotal()
        );
    }

    public static Shop toModel(ShopDTO shoppingDTO) {
        List<Item> items = shoppingDTO.getItems().stream()
                .map(DTOConverter::toModel)
                .collect(Collectors.toList());
        return new Shop(
                shoppingDTO.getId(),
                shoppingDTO.getUserIdentifier(),
                shoppingDTO.getDate(),
                items,
                shoppingDTO.getTotal());
    }

    public static ItemDTO fromModel(Item item) {
        return new ItemDTO(item.getProductIdentifier(), item.getPrice());
    }

    public static Item toModel(ItemDTO itemDTO) {
        return new Item(itemDTO.getProductIdentifier(), itemDTO.getPrice());
    }
}
