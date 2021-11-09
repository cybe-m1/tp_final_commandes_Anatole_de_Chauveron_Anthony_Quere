package com.fges.commandes.commandes.dish;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public List<Dish> listAllDishes() {
        return dishRepository.findAll();
    }
}
