package com.fges.commandes.commandes.menu.dto;

import com.fges.commandes.commandes.dish.Dish;
import lombok.Data;

import java.util.Set;

@Data
public class CreateMenuRequestDto {
    private String name;
    private String description;
    private Float tva;
    private Set<Dish> dishes;
}
