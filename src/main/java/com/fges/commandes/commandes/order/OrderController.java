package com.fges.commandes.commandes.order;

import com.fges.commandes.commandes.customer.Customer;
import com.fges.commandes.commandes.customer.CustomerNotFoundException;
import com.fges.commandes.commandes.customer.CustomerService;
import com.fges.commandes.commandes.dish.DishNotFoundException;
import com.fges.commandes.commandes.menu.MenuNotFoundException;
import com.fges.commandes.commandes.order.dto.AddDishRequestDto;
import com.fges.commandes.commandes.order.dto.AddMenuRequestDto;
import com.fges.commandes.commandes.order.dto.CreateOrderRequestDto;
import com.fges.commandes.commandes.truck.Truck;
import com.fges.commandes.commandes.truck.TruckNotFoundException;
import com.fges.commandes.commandes.truck.TruckService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v0/orders")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;
    private final TruckService truckService;

    public OrderController(OrderService orderService, CustomerService customerService, TruckService truckService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.truckService = truckService;
    }

    @PostMapping
    public Order createOrder (@RequestBody CreateOrderRequestDto orderDto) throws CustomerNotFoundException, TruckNotFoundException {
        Customer customer = customerService.findCustomerById(orderDto.getCustomerId());
        Truck truck = truckService.findTruckById(orderDto.getTruckId());

        Order order = new Order(customer, truck);

        return orderService.createOrder(order);
    }

    @PutMapping("/{id}/dishes")
    public Order addDish(@PathVariable Long id, @RequestBody AddDishRequestDto dto) throws OrderNotFoundException, DishNotFoundException {
        return orderService.addDish(id, dto.getDishId());
    }

    @PutMapping("/{id}/menus")
    public Order addMenu(@PathVariable Long id, @RequestBody AddMenuRequestDto dto) throws OrderNotFoundException, MenuNotFoundException {
        return orderService.addMenu(id, dto.getMenuId());
    }
}
