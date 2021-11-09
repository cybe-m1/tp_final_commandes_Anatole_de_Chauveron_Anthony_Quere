package com.fges.commandes.commandes.dish.dto;

import lombok.Data;

@Data
public class CreateDishRequestDto {
    private String name;
    private String description;
    private String type;
    private Float price;
    private Float tva;
}
