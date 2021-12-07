package com.fges.commandes.commandes.order;

import com.fges.commandes.commandes.customer.Customer;
import com.fges.commandes.commandes.dish.Dish;
import com.fges.commandes.commandes.dish.DishNotFoundException;
import com.fges.commandes.commandes.dish.IDish;
import com.fges.commandes.commandes.menu.IMenu;
import com.fges.commandes.commandes.menu.Menu;
import com.fges.commandes.commandes.menu.MenuNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
class OrderService implements IOrder {
    private final OrderRepository orderRepository;

    private final IDish iDish;
    private final IMenu iMenu;

    public OrderService(OrderRepository orderRepository, IDish iDish, IMenu iMenu) {
        this.orderRepository = orderRepository;
        this.iDish = iDish;
        this.iMenu = iMenu;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order findOrderById(Long id) throws OrderNotFoundException {
        return orderRepository
                .findById(id)
                .orElseThrow(OrderNotFoundException::new);
    }

    public List<Order> listCustomerPreviousOrder(Customer customer) {
        return orderRepository.findByCustomer(customer);
    }

    public Order addDish(Long orderId, Long dishId) throws OrderNotFoundException, DishNotFoundException {
        Order order = findOrderById(orderId);
        Dish dish = iDish.findDishById(dishId);

        order.getDishes().add(dish);
        return orderRepository.save(order);
    }

    public Order addMenu(Long orderId, Long menuId) throws OrderNotFoundException, MenuNotFoundException {
        Order order = findOrderById(orderId);
        Menu menu = iMenu.findMenuById(menuId);

        order.getMenus().add(menu);
        return orderRepository.save(order);
    }

}
