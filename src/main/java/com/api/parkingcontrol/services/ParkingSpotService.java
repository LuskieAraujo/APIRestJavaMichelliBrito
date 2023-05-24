package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {
    @Autowired
    ParkingSpotRepository parkingSpotRepository;
    @Transactional
    public ParkingSpotModel save(ParkingSpotModel model) {
        return parkingSpotRepository.save(model);
    }
}