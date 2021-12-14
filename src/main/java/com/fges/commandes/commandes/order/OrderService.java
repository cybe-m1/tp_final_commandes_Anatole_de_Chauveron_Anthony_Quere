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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

        Optional<OrderDish> optionalOrderDish = order.getDishes().stream().filter(dish -> dish.getDishId().equals(dishId)).findFirst();

        if (optionalOrderDish.isEmpty()) {
            // Create a new order dish
            Dish dish = iDish.findDishById(dishId);
            order.getDishes().add(new OrderDish(dish));
        } else {
            // Add one to the quantity
            optionalOrderDish
                    .get()
                    .setQuantity(optionalOrderDish.get().getQuantity() + 1);
        }
        return orderRepository.save(order);
    }

    public Order addMenu(Long orderId, Long menuId) throws OrderNotFoundException, MenuNotFoundException {
        Order order = findOrderById(orderId);
        Menu menu = iMenu.findMenuById(menuId);

//        order.getMenus().add(menu);
        return orderRepository.save(order);
    }

    public TotalAmountResponseDto getOrderAmount(Long orderId) throws OrderNotFoundException {
        Order order = findOrderById(orderId);
        float total = 0.0f;
        float tva = 0.0f;

        // Add dishes prices
//        for (Dish dish : order.getDishes()) {
//            total += dish.getPrice();
//            tva += dish.getPrice() * dish.getTva();
//        }
//
//        // Add menu prices
//        for (Menu menu : order.getMenus()) {
//            // Get dishes minus the smallest element
//            Set<Dish> dishes = menu.getDishes()
//                    .stream()
//                    .sorted((dish1, dish2) -> dish2.getPrice().compareTo(dish1.getPrice()))
//                    .skip(1)
//                    .collect(Collectors.toSet());
//
//            float menuPrice = 0.0f;
//
//            for (Dish dish : dishes) {
//                menuPrice += dish.getPrice() * (1 + dish.getTva());
//            }
//            total += menuPrice;
//            tva += menuPrice * menu.getTva();
//        }


        return new TotalAmountResponseDto(total, tva, total + tva);
    }

}
