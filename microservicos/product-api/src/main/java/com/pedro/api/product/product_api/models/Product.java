package com.pedro.api.product.product_api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.pedro.api.product.product_api.models.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String id;

    @Field("productIdentifier")
    private String productIdentifier;

    @Field("nome")
    private String nome;

    @Field("descricao")
    private String descricao;

    @Field("preco")
    private double preco;

    @DBRef
    private Category category;

    public static Product convertToEntity(ProductDTO productDTO) {

        Product product = new Product();
        product.setProductIdentifier(productDTO.getProductIdentifier());
        product.setNome(productDTO.getNome());
        product.setDescricao(productDTO.getDescricao());
        product.setPreco(productDTO.getPreco());
        product.setCategory(productDTO.getCategory());
        return product;
        
    }
}
