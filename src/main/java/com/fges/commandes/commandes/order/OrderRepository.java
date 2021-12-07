package com.fges.commandes.commandes.order;

import com.fges.commandes.commandes.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer(Customer customer);
}
