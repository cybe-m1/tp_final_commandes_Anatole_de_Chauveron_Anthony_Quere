package com.fges.commandes.commandes.dish;

import com.fges.commandes.commandes.dish.dto.CreateDishRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/dishs")
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<Dish> getAllDish() {
        return dishService.listAllDishs();
    }

    @PostMapping
    public Dish createDish(@RequestBody CreateDishRequestDto createDishRequestDto) {
        Dish dish = new Dish();

        dish.setName(createDishRequestDto.getName());
        dish.setDescription(createDishRequestDto.getDescription());
        dish.setType(createDishRequestDto.getType());
        dish.setTva(createDishRequestDto.getTva());
        dish.setPrice(createDishRequestDto.getPrice());

        dishService.createDish(dish);
    }
}
