package com.fges.commandes.commandes.customer;

import com.fges.commandes.commandes.customer.dto.CreateCustomerRequestDto;
import com.fges.commandes.commandes.order.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v0/customers")
class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/phonenumber/{phoneNumber}")
    public Customer getCustomerByPhoneNumber(@PathVariable String phoneNumber) throws CustomerNotFoundException {
        return customerService.findByPhoneNumber(phoneNumber);
    }

    @GetMapping("/{customer_id}/previous_orders")
    public List<Order> listCustomerPreviousOrder(@PathVariable Long customer_id) throws CustomerNotFoundException {
        return customerService.listPreviousOrder(customer_id);
    }

    @PostMapping
    public Customer postCustomer(@RequestBody CreateCustomerRequestDto createCustomerRequestDto) throws CustomerPhoneNumberTakenException {
        Customer customer = new Customer();
        customer.setFirstName(createCustomerRequestDto.getFirstName());
        customer.setLastName(createCustomerRequestDto.getLastName());
        customer.setPhoneNumber(createCustomerRequestDto.getPhoneNumber());
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> listCustomers() {
        return customerService.listCustomers();
    }
}
