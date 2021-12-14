package com.fges.commandes.commandes.order;

import com.fges.commandes.commandes.customer.Customer;
import com.fges.commandes.commandes.dish.Dish;
import com.fges.commandes.commandes.menu.Menu;
import com.fges.commandes.commandes.truck.Truck;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Truck truck;

    @ManyToMany
    private List<Dish> dishes;

    @ManyToMany
    private List<Menu> menus;

    public Order(Customer customer, Truck truck) {
        this.customer = customer;
        this.truck = truck;
        this.dishes = new ArrayList<>();
        this.menus = new ArrayList<>();
    }
}
