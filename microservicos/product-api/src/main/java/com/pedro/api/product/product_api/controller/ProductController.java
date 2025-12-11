package com.pedro.api.product.product_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pedro.api.product.product_api.services.ProductService;
import com.pedro.dto.ProductDTO;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable("id") String id) {
        return productService.findById(id);
    }

    @GetMapping("/pageable")
    public Page<ProductDTO> getPageable(Pageable pageable) {
        return productService.getAllPage(pageable);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> findByCategory(@PathVariable String categoryId) {
        return productService.getByCategory(categoryId);
    }
    
    @GetMapping("/identifier/{productIdentifier}")
    public ProductDTO findByProductIdentifier(@PathVariable("productIdentifier") String productIdentifier) {
        return productService.getByProductIdentifier(productIdentifier);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO newProduct(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }
    
    @PutMapping("/{id}")
    public ProductDTO editProduct(@PathVariable String id, @RequestBody ProductDTO productDTO) {
        return productService.edit(id, productDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ProductDTO deleteProduct(@PathVariable String id) {
        return productService.delete(id);
    }
}