package com.vacation_home_backend.vacation_home_backend.controller;

import com.vacation_home_backend.vacation_home_backend.model.Stay;
import com.vacation_home_backend.vacation_home_backend.service.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"}) // Vite default port
public class StayController {

    @Autowired
    StayService stayService;

    @GetMapping("/v1/stays")
    public List<Stay> getStays(){
        return stayService.getStays();
    }

    @GetMapping("/v1/stays/{id}")
    public ResponseEntity<Stay> getStay(@PathVariable Long id){
        System.out.println("🔍 Looking for stay ID: " + id); // Debug log


        return stayService.getStay(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
