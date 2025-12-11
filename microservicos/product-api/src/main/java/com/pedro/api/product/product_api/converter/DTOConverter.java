package com.pedro.api.product.product_api.converter;

import com.pedro.api.product.product_api.models.Category;
import com.pedro.api.product.product_api.models.Product;
import com.pedro.dto.CategoryDTO;
import com.pedro.dto.ProductDTO;

public class DTOConverter {
    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setNome(product.getNome());
        productDTO.setDescricao(product.getDescricao());
        productDTO.setPreco(product.getPreco());
        productDTO.setCategory(DTOConverter.convert(product.getCategory()));
        return productDTO;
    }
}