package com.fges.commandes.commandes.menu;

import com.fges.commandes.commandes.dish.Dish;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private Float tva;
    @ManyToMany
    private Set<Dish> dishes;
}
