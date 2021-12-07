package com.fges.commandes.commandes.truck;

public interface ITruck {
    Truck findTruckById(Long id) throws TruckNotFoundException;
}
