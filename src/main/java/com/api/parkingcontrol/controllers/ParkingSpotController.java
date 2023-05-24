package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/parking-spot")
public class ParkingSpotController {
    final ParkingSpotService service;
    public ParkingSpotController(ParkingSpotService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto dto){
        var model = new ParkingSpotModel();
        BeanUtils.copyProperties(dto, model);
        model.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(model));
    }
}