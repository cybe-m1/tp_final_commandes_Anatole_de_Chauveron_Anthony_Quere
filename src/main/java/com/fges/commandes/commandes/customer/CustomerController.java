package com.fges.commandes.commandes.customer;

import com.fges.commandes.commandes.customer.dto.CreateCustomerRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v0/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/phonenumber/{phoneNmber}")
    public Optional<Customer> getCustomerByPhoneNumber(@PathVariable String phoneNmber) {
        return customerService.findByPhoneNumber(phoneNmber);
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
