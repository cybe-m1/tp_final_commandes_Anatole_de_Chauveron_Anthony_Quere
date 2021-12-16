package com.fges.commandes.commandes.dish;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findAllByNameContaining(String name);
}
