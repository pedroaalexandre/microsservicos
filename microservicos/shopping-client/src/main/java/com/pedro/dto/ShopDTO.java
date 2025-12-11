package com.pedro.dto;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {

    private String id;

    @NotBlank(message = "O campo user_identifier não pode ser vazio ou nulo.")
    private String userIdentifier;

    @NotNull(message = "A data da compra deve ser informada.")
    private LocalDateTime date;

    @NotBlank(message = "O campo items não pode ser vazio ou nulo.")
    private List<ItemDTO> items;

    @PositiveOrZero(message = "O número total de itens não pode ser negativo.")
    private Integer total;
}
