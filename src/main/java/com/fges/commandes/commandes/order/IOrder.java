package com.fges.commandes.commandes.order;

import com.fges.commandes.commandes.customer.Customer;

import java.util.List;

public interface IOrder {
    List<Order> listCustomerPreviousOrder(Customer customer);
}
