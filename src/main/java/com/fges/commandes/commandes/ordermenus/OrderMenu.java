package com.fges.commandes.commandes.ordermenus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fges.commandes.commandes.menu.Menu;
import com.fges.commandes.commandes.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_order_menu")
public class OrderMenu {
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
    private Menu menu;

    public OrderMenu(Order order, Menu menu) {
        this.quantity = 1;
        this.order = order;
        this.menu = menu;
    }
}
