package com.fges.commandes.commandes.dish.dto;

import com.fges.commandes.commandes.dish.DishType;
import lombok.Data;

@Data
public class CreateDishRequestDto {
    private String name;
    private String description;
    private DishType type;
    private Float price;
    private Float tva;
}
