package com.pedro.api.shopping.shopping_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.api.shopping.shopping_api.models.dto.ShopDTO;
import com.pedro.api.shopping.shopping_api.services.ShopService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/shopping")
@RequiredArgsConstructor
public class ShopController {
    
    public final ShopService shopService;

    @GetMapping
    public List<ShopDTO> getAll() {
        return shopService.getAll();
    }

    @GetMapping("/{id}")
    public ShopDTO findById(@PathVariable String id) {
        return shopService.findById(id);
    }

    @GetMapping("/shopByUser")
    public List<ShopDTO> findByUser(@RequestParam(name = "userIdentifier", required = true) String userIdentifier) {
        return shopService.findByUser(userIdentifier);
    }

    @GetMapping("/shopByDate")
    public List<ShopDTO> findByDate(@RequestParam(name = "startDate", required = true) LocalDateTime startDate, @RequestParam(name = "endDate", required = false) LocalDateTime endDate) {
        return shopService.findByDate(startDate, endDate);
    }
    
    @GetMapping("/product/{productIdentifier}")
    public List<ShopDTO> findByProductId(@PathVariable String productIdentifier) {
        return shopService.findByProductId(productIdentifier);
    }

    @GetMapping("/report")
    public List<ShopDTO> generateReport(@RequestParam(name = "startDate", required = true) LocalDateTime startDate, @RequestParam(name = "endDate", required = false) LocalDateTime endDate) {
        return shopService.findByDate(startDate, endDate);
    }

    @GetMapping("/search")
    public List<ShopDTO> searchShops(@RequestParam(name = "startDate", required = true) LocalDateTime startDate,
                                       @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
                                       @RequestParam(name = "minValue", required = false) Integer minValue) {
        return shopService.searchShops(startDate, endDate, minValue);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShopDTO save(@RequestBody ShopDTO shopDTO) {
        return shopService.save(shopDTO);
    }
    
}
