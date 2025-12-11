package com.pedro.dto;

import org.springframework.data.annotation.Id;

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
    private CategoryDTO category;
}
