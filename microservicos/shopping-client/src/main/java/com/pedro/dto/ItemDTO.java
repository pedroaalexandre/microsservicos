package com.pedro.dto;

import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    @Field("product_identifier")
    private String productIdentifier;

    @Positive
    private Double price;

}
