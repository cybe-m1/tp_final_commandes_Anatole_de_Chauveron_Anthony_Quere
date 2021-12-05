package com.fges.commandes.commandes.customer;

import com.fges.commandes.commandes.customer.dto.CreateCustomerRequestDto;
import com.fges.commandes.commandes.order.Order;
import com.fges.commandes.commandes.order.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v0/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;

    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @GetMapping("/phonenumber/{phoneNmber}")
    public Optional<Customer> getCustomerByPhoneNumber(@PathVariable String phoneNmber) {
        return customerService.findByPhoneNumber(phoneNmber);
    }

    @GetMapping("/{customer_id}/previous_orders")
    public List<Order> listCustomerPreviousOrder(@PathVariable Long customer_id) {
        return orderService.listCustomerPreviousOrder(customer_id);
    }

    @PostMapping
    public Customer postCustomer(@RequestBody CreateCustomerRequestDto createCustomerRequestDto) {
        Customer customer = new Customer();
        customer.setFirstName(createCustomerRequestDto.getFirstName());
        customer.setLastName(createCustomerRequestDto.getLastName());
        customer.setPhoneNumber(createCustomerRequestDto.getPhoneNumber());
        return customerService.createCustomer(customer);
    }
}
