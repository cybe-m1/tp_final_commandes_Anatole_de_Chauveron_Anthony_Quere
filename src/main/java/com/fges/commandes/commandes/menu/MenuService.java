package com.fges.commandes.commandes.menu;

import com.fges.commandes.commandes.dish.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class MenuService implements IMenu {
    private final MenuRepository menuRepository;
    private final IDish iDish;

    public MenuService(MenuRepository menuRepository, IDish iDish) {
        this.menuRepository = menuRepository;
        this.iDish = iDish;
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> listAllMenus() {
        return menuRepository.findAll();
    }

    public Menu addDishToMenu(Long id, Long dishId) throws Exception {
        Optional<Menu> menu = menuRepository.findById(id);
        menu.orElseThrow(MenuNotFoundException::new);

        Dish dish = iDish.findDishById(dishId);

        menu.get()
                .getDishes()
                .add(dish);

        return menuRepository.save(menu.get());
    }

    public Menu removeDishFromMenu(Long id, Long dishId) throws Exception {
        Optional<Menu> menu = menuRepository.findById(id);
        menu.orElseThrow(MenuNotFoundException::new);

        Dish dish = iDish.findDishById(dishId);

        menu.get()
                .getDishes()
                .remove(dish);

        return menuRepository.save(menu.get());
    }

    public Menu findMenuById(Long id) throws MenuNotFoundException {
        return menuRepository
                .findById(id)
                .orElseThrow(MenuNotFoundException::new);
    }
}
