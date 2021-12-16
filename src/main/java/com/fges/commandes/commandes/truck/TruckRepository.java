package com.fges.commandes.commandes.truck;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


interface TruckRepository extends JpaRepository<Truck, Long> {
    List<Truck> findAllByNameContaining(String name);
}
