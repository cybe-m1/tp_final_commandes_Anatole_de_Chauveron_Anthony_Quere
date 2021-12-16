package com.fges.commandes.commandes.order;

import com.fges.commandes.commandes.customer.Customer;
import com.fges.commandes.commandes.dish.Dish;
import com.fges.commandes.commandes.menu.Menu;
import com.fges.commandes.commandes.orderdishes.OrderDish;
import com.fges.commandes.commandes.ordermenus.OrderMenu;
import com.fges.commandes.commandes.truck.Truck;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_order")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Truck truck;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDish> dishes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderMenu> menus;

    public Order(Customer customer, Truck truck) {
        this.customer = customer;
        this.truck = truck;
        this.dishes = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        Optional<OrderDish> optionalDish = dishes.stream().filter(d -> d.getDish().getId().equals(dish.getId())).findFirst();

        if (optionalDish.isEmpty()) {
            dishes.add(new OrderDish(this, dish));
        } else {
            optionalDish.get().setQuantity(optionalDish.get().getQuantity() + 1);
        }
    }

    public void addMenu(Menu menu) {
        Optional<OrderMenu> optionalMenu = menus.stream().filter(m -> m.getMenu().getId().equals(menu.getId())).findFirst();

        if (optionalMenu.isEmpty()) {
            menus.add(new OrderMenu(this, menu));
        } else {
            optionalMenu.get().setQuantity(optionalMenu.get().getQuantity() + 1);
        }
    }
}
