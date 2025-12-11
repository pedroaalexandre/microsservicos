package com.pedro.api.shopping.shopping_api.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pedro.api.shopping.shopping_api.converter.DTOConverter;
import com.pedro.api.shopping.shopping_api.models.Item;
import com.pedro.api.shopping.shopping_api.models.Shop;
import com.pedro.api.shopping.shopping_api.repositories.ShopRepository;
import com.pedro.dto.ShopDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {
    
    private final ShopRepository shopRepository;

    public List<ShopDTO> getAll() {
        List<ShopDTO> shop = shopRepository.findAll()
                                .stream()
                                .map(DTOConverter::fromModel)
                                .collect(Collectors.toList());
        return shop;
    }

    public ShopDTO findById(String id) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return DTOConverter.fromModel(shop);
    }

    public ShopDTO save(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setDate(LocalDateTime.now());
        shop.setItems(shopDTO.getItems().stream().map(Item::convertToEntity).toList());

        Integer totalItems = shop.getItems().size();
        shop.setTotal(totalItems);

        shop = shopRepository.save(shop);

        return DTOConverter.fromModel(shop);
    }

    public List<ShopDTO> findByUser(String userIdentifier) {
        List<Shop> shop = shopRepository.queryByUserIdentifierLike(userIdentifier);
        return shop.stream()
                    .map(DTOConverter::fromModel)
                    .collect(Collectors.toList());
    }

    public List<ShopDTO> findByDate(LocalDateTime startDate, LocalDateTime endDate) {
        List<Shop> shop = shopRepository.queryByDateBetween(startDate, endDate);
        return shop.stream()
                    .map(DTOConverter::fromModel)
                    .collect(Collectors.toList());
    }

    public List<ShopDTO> findByProductId(String productIdentifier) {
        List<Shop> shop = shopRepository.findByItems_ProductIdentifier(productIdentifier);
        return shop.stream()
                    .map(DTOConverter::fromModel)
                    .collect(Collectors.toList());
    }

    public List<ShopDTO> searchShops(LocalDateTime startDate, LocalDateTime endDate, Integer minValue) {
        List<Shop> shops = shopRepository.findByDateBetweenAndTotalGreaterThanEqual(startDate, endDate, minValue);
        return shops.stream()
                .map(DTOConverter::fromModel)
                .collect(Collectors.toList());
    }
}
