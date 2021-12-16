package com.fges.commandes.commandes.order;

import com.fges.commandes.commandes.customer.Customer;
import com.fges.commandes.commandes.dish.Dish;
import com.fges.commandes.commandes.dish.DishNotFoundException;
import com.fges.commandes.commandes.dish.IDish;
import com.fges.commandes.commandes.menu.IMenu;
import com.fges.commandes.commandes.menu.Menu;
import com.fges.commandes.commandes.menu.MenuNotFoundException;
import com.fges.commandes.commandes.order.dto.TotalAmountResponseDto;
import com.fges.commandes.commandes.orderdishes.OrderDish;
import com.fges.commandes.commandes.ordermenus.OrderMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
class OrderService implements IOrder {
    private final OrderRepository orderRepository;

    private final IDish iDish;
    private final IMenu iMenu;

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
        order.addDish(dish);
        return orderRepository.save(order);
    }

    public Order addMenu(Long orderId, Long menuId) throws OrderNotFoundException, MenuNotFoundException {
        Order order = findOrderById(orderId);
        Menu menu = iMenu.findMenuById(menuId);
        order.addMenu(menu);
        return orderRepository.save(order);
    }

    public TotalAmountResponseDto getOrderAmount(Long orderId) throws OrderNotFoundException {
        Order order = findOrderById(orderId);
        float total = 0.0f;
        float tva = 0.0f;

        // Add dishes prices
        for (OrderDish orderDish : order.getDishes()) {
            total += orderDish.getDish().getPrice() * orderDish.getQuantity();
            tva += orderDish.getDish().getPrice() * orderDish.getDish().getTva() * orderDish.getQuantity();
        }

        // Add menu prices
        for (OrderMenu orderMenu : order.getMenus()) {
            // Get dishes minus the smallest element
            Set<Dish> dishes = orderMenu.getMenu().getDishes()
                    .stream()
                    .sorted((dish1, dish2) -> dish2.getPrice().compareTo(dish1.getPrice()))
                    .skip(1)
                    .collect(Collectors.toSet());

            float menuPrice = 0.0f;

            for (Dish dish : dishes) {
                menuPrice += dish.getPrice() * (1 + dish.getTva());
            }
            total += menuPrice;
            tva += menuPrice * orderMenu.getMenu().getTva();
        }


        return new TotalAmountResponseDto(total, tva, total + tva);
    }

}
