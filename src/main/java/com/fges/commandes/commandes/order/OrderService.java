package com.fges.commandes.commandes.order;

import com.fges.commandes.commandes.customer.CustomerService;
import com.fges.commandes.commandes.dish.Dish;
import com.fges.commandes.commandes.dish.DishNotFoundException;
import com.fges.commandes.commandes.dish.DishService;
import com.fges.commandes.commandes.menu.Menu;
import com.fges.commandes.commandes.menu.MenuNotFoundException;
import com.fges.commandes.commandes.menu.MenuService;
import com.fges.commandes.commandes.truck.TruckService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService implements IOrder {
    private final OrderRepository orderRepository;

    private final DishService dishService;
    private final MenuService menuService;
    private final TruckService truckService;
    private final CustomerService customerService;

    public OrderService(OrderRepository orderRepository, DishService dishService, MenuService menuService, TruckService truckService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.dishService = dishService;
        this.menuService = menuService;
        this.truckService = truckService;
        this.customerService = customerService;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order findOrderById(Long id) throws OrderNotFoundException {
        return orderRepository
                .findById(id)
                .orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public List<Order> listCustomerPreviousOrder(Long id) {
        return (List<Order>) orderRepository
                .findAll()
                .stream()
                .filter(order -> order.getCustomer().getId().equals(id))
                .limit(100);
    }

    public Order addDish(Long orderId, Long dishId) throws OrderNotFoundException, DishNotFoundException {
        Order order = findOrderById(orderId);
        Dish dish = dishService.findDishById(dishId);

        order.getDishes().add(dish);
        return orderRepository.save(order);
    }

    public Order addMenu(Long orderId, Long menuId) throws OrderNotFoundException, MenuNotFoundException {
        Order order = findOrderById(orderId);
        Menu menu = menuService.findMenuById(menuId);

        order.getMenus().add(menu);
        return orderRepository.save(order);
    }

}
