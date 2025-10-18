package com.pedro.api.product.product_api.models.dto;

import org.springframework.data.annotation.Id;

import com.pedro.api.product.product_api.models.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    @Id
    private String id;

    @NotBlank(message = "O campo nome não pode ser vazio ou null")
    private String nome;

    public static CategoryDTO convertToDto(Category category) {

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());

        return categoryDTO;
    }
}