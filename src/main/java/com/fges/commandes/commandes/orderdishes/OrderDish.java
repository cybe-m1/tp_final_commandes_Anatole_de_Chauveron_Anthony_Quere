package com.fges.commandes.commandes.orderdishes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class OrderDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn
    private Order order;

    @ManyToOne
    @JoinColumn
    private Dish dish;

    public OrderDish(Order order, Dish dish) {
        this.quantity = 1;
        this.order = order;
        this.dish = dish;
    }

}
