package com.pedro.api.product.product_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pedro.api.product.product_api.models.Category;
import com.pedro.api.product.product_api.models.Product;
import com.pedro.api.product.product_api.models.dto.CategoryDTO;
import com.pedro.api.product.product_api.models.dto.ProductDTO;
import com.pedro.api.product.product_api.repositories.CategoryRepository;
import com.pedro.api.product.product_api.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                        .map(ProductDTO::convertToDto)
                        .collect(Collectors.toList());
    }

    public ProductDTO findById(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return ProductDTO.convertToDto(product);
    }

    public ProductDTO save(ProductDTO productDTO) {
        Product product = productRepository.save(Product.convertToEntity(productDTO));
        Product findProduct = productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException());
        return ProductDTO.convertToDto(findProduct);
    }

    public ProductDTO edit(String id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException());

        if(productDTO.getNome() != null && !product.getNome().equals(productDTO.getNome())) {
            product.setNome(productDTO.getNome());
        }
        if(productDTO.getProductIdentifier() != null && !product.getProductIdentifier().equals(productDTO.getProductIdentifier())) {
            product.setProductIdentifier(productDTO.getProductIdentifier());
        }
        if(productDTO.getDescricao() != null && !product.getDescricao().equals(productDTO.getDescricao())) {
            product.setDescricao(productDTO.getDescricao());
        }
        if(productDTO.getPreco() != 0 && product.getPreco() != productDTO.getPreco()) {
            product.setPreco(productDTO.getPreco());
        }
        if(productDTO.getCategory() != null && !product.getCategory().getId().equals(productDTO.getCategory().getId())) {
            CategoryDTO categoryDTO = new CategoryDTO(productDTO.getCategory().getId(), productDTO.getCategory().getNome());
            product.setCategory(Category.convertToEntity(categoryDTO));
        }

        product = productRepository.save(product);

        return ProductDTO.convertToDto(product);
    }

    public ProductDTO delete(String id) {
        Product product = productRepository.findById(id)
                                            .orElseThrow(() -> new RuntimeException());
        
        productRepository.delete(product);
        return ProductDTO.convertToDto(product);
    }

    public Page<ProductDTO> getAllPage(Pageable page) {
        Page<Product> produtos = productRepository.findAll(page);
        return produtos
            .map(ProductDTO::convertToDto);
    }

    public List<ProductDTO> getByCategory(String id) {
        Category category = categoryRepository.findById(id)
                                                .orElseThrow(() -> new RuntimeException());

        List<Product> products = productRepository.findByCategory(category);

        return products.stream()
                            .map(ProductDTO::convertToDto)
                            .collect(Collectors.toList());
    }

    public ProductDTO getByProductIdentifier(String productIdentifier) {
        Product products = productRepository.findByProductIdentifier(productIdentifier);
        return ProductDTO.convertToDto(products);
    }
}
