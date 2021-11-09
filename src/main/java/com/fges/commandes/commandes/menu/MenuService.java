package com.fges.commandes.commandes.menu;

import com.fges.commandes.commandes.dish.Dish;
import com.fges.commandes.commandes.dish.DishException;
import com.fges.commandes.commandes.dish.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final DishRepository dishRepository;

    public MenuService(MenuRepository menuRepository, DishRepository dishRepository) {
        this.menuRepository = menuRepository;
        this.dishRepository = dishRepository;
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> listAllMenus() {
        return menuRepository.findAll();
    }

    public Menu addDishToMenu(Long id, Long dishId) throws Exception {
        Optional<Menu> menu = menuRepository.findById(id);
        menu.orElseThrow(MenuException::new);

        Optional<Dish> dish = dishRepository.findById(dishId);
        dish.orElseThrow(DishException::new);

        menu.get().getDishes().add(dish.get());
        return menuRepository.save(menu.get());
    }

    public Menu removeDishFromMenu(Long id, Long dishId) throws Exception {
        Optional<Menu> menu = menuRepository.findById(id);
        menu.orElseThrow(MenuException::new);

        Optional<Dish> dish = dishRepository.findById(dishId);
        dish.orElseThrow(DishException::new);

        menu.get().getDishes().remove(dish.get());
        return menuRepository.save(menu.get());
    }
}
