package com.pedro.dto;

import org.springframework.data.annotation.Id;

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

}