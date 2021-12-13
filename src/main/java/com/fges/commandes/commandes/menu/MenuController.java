package com.fges.commandes.commandes.menu;

import com.fges.commandes.commandes.dish.Dish;
import com.fges.commandes.commandes.menu.dto.AddDishRequestDto;
import com.fges.commandes.commandes.menu.dto.CreateMenuRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.zip.DeflaterInputStream;

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

    @PostMapping("/{id}/dish")
    public Menu addDishToMenu(@PathVariable Long id, @RequestBody AddDishRequestDto dto) throws Exception {
        return menuService.addDishToMenu(id, dto.getDishId());
    }

    @DeleteMapping("/{id}/dish")
    public Menu removeDishFromMenu(@PathVariable Long id, @RequestBody AddDishRequestDto dto) throws Exception {
        return menuService.removeDishFromMenu(id, dto.getDishId());
    }
}
