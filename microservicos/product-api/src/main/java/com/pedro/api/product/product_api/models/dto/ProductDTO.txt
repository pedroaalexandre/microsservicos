package com.pedro.api.product.product_api.models.dto;

import org.springframework.data.annotation.Id;

import com.pedro.api.product.product_api.models.Category;
import com.pedro.api.product.product_api.models.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @Id
    private String id;

    @NotBlank(message = "Necessário a identificação do produto")
    private String productIdentifier;

    @NotBlank(message = "Necessário digitar o nome")
    private String nome;

    private String descricao;

    @Positive
    private double preco;

    @NotBlank(message = "Necessário estar incluído em uma categoria")
    private Category category;

    public static ProductDTO convertToDto(Product product) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setNome(product.getNome());
        productDTO.setDescricao(product.getDescricao());
        productDTO.setPreco(product.getPreco());
        productDTO.setCategory(product.getCategory());
        return productDTO;
        
    }
}
