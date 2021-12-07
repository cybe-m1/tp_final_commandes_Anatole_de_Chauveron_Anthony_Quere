package com.fges.commandes.commandes.customer;

import com.fges.commandes.commandes.order.IOrder;
import com.fges.commandes.commandes.order.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final IOrder iOrder;

    public CustomerService(CustomerRepository customerRepository, IOrder iOrder) {
        this.customerRepository = customerRepository;
        this.iOrder = iOrder;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findByPhoneNumber(String phoneNumber) {
        return customerRepository.findCustomerByPhoneNumber(phoneNumber);
    }

    public Customer findCustomerById(Long id) throws CustomerNotFoundException {
        return this.customerRepository
                .findById(id)
                .orElseThrow(CustomerNotFoundException::new);
    }

    public List<Order> listPreviousOrder(Long id) throws CustomerNotFoundException {
        Customer customer = this.customerRepository
                .findById(id)
                .orElseThrow(CustomerNotFoundException::new);

        return iOrder.listCustomerPreviousOrder(customer.getId());
    }
}
