package com.fges.commandes.commandes.truck;

import com.fges.commandes.commandes.truck.dto.CreateTruckRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/trucks")
public class TruckController {

    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping
    public List<Truck> getTrucks() {
        return truckService.listTrucks();
    }

    @PostMapping
    public Truck postTruck(@RequestBody CreateTruckRequestDto createTruckRequestDto) {
        Truck truck = new Truck();
        truck.setName(createTruckRequestDto.getName());
        truck.setDescription(createTruckRequestDto.getDescription());
        return truckService.createTruck(truck);
    }
}
