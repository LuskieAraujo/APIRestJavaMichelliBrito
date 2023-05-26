package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpotService {
    @Autowired
    ParkingSpotRepository repo;
    @Transactional
    public ParkingSpotModel save(ParkingSpotModel model) {
        return repo.save(model);
    }
    
    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return repo.existsByParkingSpotNumber(parkingSpotNumber);
    }
    
    public boolean existsByLicensePlate(String licensePlateCar) {
        return repo.existsByLicensePlateCar(licensePlateCar);
    }
    
    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return repo.existsByApartmentAndBlock(apartment, block);
    }
    
    public List<ParkingSpotModel> findAll() {
        return repo.findAll();
    }
}