package com.vacation_home_backend.vacation_home_backend.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class ReservationController {

    @GetMapping("/v1/reserve")
    public ResponseEntity<String> reserve(){
        return ResponseEntity.ok("Reservation Done");
    }
}
