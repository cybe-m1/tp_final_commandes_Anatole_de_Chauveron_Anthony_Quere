package com.fges.commandes.commandes.orderdishes;

import com.fges.commandes.commandes.dish.Dish;
import com.fges.commandes.commandes.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_order_dish")
@IdClass(OrderDishPrimaryKeys.class)
public class OrderDish {

    @Id
    private Long orderId;
    @Id
    private Long dishId;

    int quantity;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "dishId", referencedColumnName = "id", insertable = false, updatable = false)
    private Dish dish;

    public OrderDish(Dish dish) {
        this.quantity = 1;
        this.dish = dish;
    }
}
