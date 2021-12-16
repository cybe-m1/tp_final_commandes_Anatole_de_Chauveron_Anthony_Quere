package com.fges.commandes.commandes.order;

import com.fges.commandes.commandes.customer.Customer;
import com.fges.commandes.commandes.customer.CustomerNotFoundException;
import com.fges.commandes.commandes.customer.ICustomer;
import com.fges.commandes.commandes.dish.DishNotFoundException;
import com.fges.commandes.commandes.menu.MenuNotFoundException;
import com.fges.commandes.commandes.order.dto.AddDishRequestDto;
import com.fges.commandes.commandes.order.dto.AddMenuRequestDto;
import com.fges.commandes.commandes.order.dto.CreateOrderRequestDto;
import com.fges.commandes.commandes.order.dto.TotalAmountResponseDto;
import com.fges.commandes.commandes.truck.ITruck;
import com.fges.commandes.commandes.truck.Truck;
import com.fges.commandes.commandes.truck.TruckNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v0/orders")
class OrderController {

    private final OrderService orderService;
    private final ITruck iTruck;
    private final ICustomer iCustomer;

    public OrderController(OrderService orderService, ITruck iTruck, ICustomer iCustomer) {
        this.orderService = orderService;
        this.iTruck = iTruck;
        this.iCustomer = iCustomer;
    }

    @PostMapping
    public Order createOrder (@RequestBody CreateOrderRequestDto orderDto) throws CustomerNotFoundException, TruckNotFoundException {
        Customer customer = iCustomer.findCustomerById(orderDto.getCustomerId());
        Truck truck = iTruck.findTruckById(orderDto.getTruckId());

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

    @GetMapping("/{id}/total")
    public TotalAmountResponseDto getOrderTotalAmount(@PathVariable Long id) throws OrderNotFoundException {
        return orderService.getOrderAmount(id);
    }
}
