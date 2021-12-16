package com.fges.commandes.commandes.truck;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class TruckService implements ITruck {

    private final TruckRepository truckRepository;

    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public List<Truck> listTrucks(String search) {
        return this.truckRepository.findAllByNameContaining(search);
    }

    public Truck createTruck(Truck truck) {
        return this.truckRepository.save(truck);
    }

    public Truck findTruckById(Long id) throws TruckNotFoundException {
        return truckRepository
                .findById(id)
                .orElseThrow(TruckNotFoundException::new);
    }

}
