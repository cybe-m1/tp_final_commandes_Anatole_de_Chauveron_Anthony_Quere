package com.fges.commandes.commandes.menu;

import com.fges.commandes.commandes.menu.dto.AddDishToMenuRequestDto;
import com.fges.commandes.commandes.menu.dto.CreateMenuRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/menus")
class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public Menu createMenu(@RequestBody CreateMenuRequestDto createMenuRequestDto) {
        Menu menu = new Menu();
        menu.setName(createMenuRequestDto.getName());
        menu.setDescription(createMenuRequestDto.getDescription());
        menu.setTva(createMenuRequestDto.getTva());
        menu.setDishes(createMenuRequestDto.getDishes());

        return menuService.createMenu(menu);
    }

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.listAllMenus();
    }

    @PostMapping("/{id}/dishes")
    public Menu addDishToMenu(@PathVariable Long id, @RequestBody AddDishToMenuRequestDto addDishToMenuRequestDto) throws Exception {
        return menuService.addDishToMenu(id, addDishToMenuRequestDto.getDishId());
    }

    @DeleteMapping("/{id}/dishes/{dishId}")
    public Menu removeDishFromMenu(@PathVariable Long id, @PathVariable Long dishId) throws Exception {
        return menuService.removeDishFromMenu(id, dishId);
    }
}
