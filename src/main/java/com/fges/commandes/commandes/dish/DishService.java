package com.fges.commandes.commandes.dish;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DishService implements IDish {
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

    public Dish findDishById(Long id) throws DishNotFoundException {
        return this.dishRepository
                .findById(id)
                .orElseThrow(DishNotFoundException::new);
    }
}
