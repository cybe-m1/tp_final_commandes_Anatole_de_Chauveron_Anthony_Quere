package com.fges.commandes.commandes.dish;

public interface IDish {
    Dish findDishById(Long id) throws DishNotFoundException;
}
