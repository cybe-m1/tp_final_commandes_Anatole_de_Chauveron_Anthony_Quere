package com.fges.commandes.commandes.truck;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckService {

    private final TruckRepository truckRepository;

    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public List<Truck> listTrucks() {
        return this.truckRepository.findAll();
    }

    public Truck createTruck(Truck truck) {
        return this.truckRepository.save(truck);
    }

}
