package com.vacation_home_backend.vacation_home_backend.controller;

import com.vacation_home_backend.vacation_home_backend.model.Stay;
import com.vacation_home_backend.vacation_home_backend.service.ReservationService;
import com.vacation_home_backend.vacation_home_backend.service.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;  // ← GET
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class ReservationController {

    @Autowired
    StayService stayService;
    @Autowired
    ReservationService reservationService;

    @GetMapping("/v1/reserve/{stayId}")
    public ResponseEntity<String> reserve(@PathVariable Long stayId){
        Optional<Stay> stay = stayService.getStay(stayId);

        if (stay.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        reservationService.reserveStay(stayId, stay.get().getName());
        return ResponseEntity.ok("Reservation Done!");
    }
}
