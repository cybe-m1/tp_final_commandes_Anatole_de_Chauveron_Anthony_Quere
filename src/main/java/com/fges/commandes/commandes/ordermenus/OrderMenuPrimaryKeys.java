package com.fges.commandes.commandes.ordermenus;

import java.io.Serializable;
import java.util.Objects;

public class OrderMenuPrimaryKeys implements Serializable {
    private Long orderId;
    private Long menuId;

    public OrderMenuPrimaryKeys(Long orderId, Long menuId) {
        this.orderId = orderId;
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMenuPrimaryKeys that = (OrderMenuPrimaryKeys) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(menuId, that.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, menuId);
    }
}
