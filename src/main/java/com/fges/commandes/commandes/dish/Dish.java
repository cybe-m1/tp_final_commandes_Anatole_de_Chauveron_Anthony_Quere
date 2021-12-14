package com.fges.commandes.commandes.dish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "t_dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private DishType type;
    private Float price;
    private Float tva;
}
