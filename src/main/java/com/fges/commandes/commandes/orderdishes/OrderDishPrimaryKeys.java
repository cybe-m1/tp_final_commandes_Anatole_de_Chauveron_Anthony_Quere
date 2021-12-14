package com.fges.commandes.commandes.orderdishes;

import java.io.Serializable;
import java.util.Objects;

public class OrderDishPrimaryKeys implements Serializable {
    private Long orderId;
    private Long dishId;

    public OrderDishPrimaryKeys(Long orderId, Long dishId) {
        this.orderId = orderId;
        this.dishId = dishId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDishPrimaryKeys that = (OrderDishPrimaryKeys) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(dishId, that.dishId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, dishId);
    }
}
