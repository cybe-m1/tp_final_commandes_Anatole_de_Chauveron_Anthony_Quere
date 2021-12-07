package com.fges.commandes.commandes.order;

import java.util.List;

public interface IOrder {
    List<Order> listCustomerPreviousOrder(Long id);
}
