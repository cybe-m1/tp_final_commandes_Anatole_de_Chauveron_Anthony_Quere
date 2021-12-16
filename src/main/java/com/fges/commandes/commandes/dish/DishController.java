package com.fges.commandes.commandes.dish;

import com.fges.commandes.commandes.dish.dto.CreateDishRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/dishes")
class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<Dish> getAllDishes(@RequestParam(defaultValue = "") String search) {
        return dishService.findByNameContaining(search);
    }

    @PostMapping
    public Dish createDish(@RequestBody CreateDishRequestDto createDishRequestDto) {
        Dish dish = new Dish();

        dish.setName(createDishRequestDto.getName());
        dish.setDescription(createDishRequestDto.getDescription());
        dish.setType(createDishRequestDto.getType());
        dish.setTva(createDishRequestDto.getTva());
        dish.setPrice(createDishRequestDto.getPrice());

        return dishService.createDish(dish);
    }
}
