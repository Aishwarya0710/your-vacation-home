package com.vacation_home_backend.vacation_home_backend.controller;

import com.vacation_home_backend.vacation_home_backend.model.Stay;
import com.vacation_home_backend.vacation_home_backend.service.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StayController {

    @Autowired
    StayService stayService;

    @GetMapping("/v1/stays")
    public List<Stay> getStays(){
        return stayService.getStays();
    }
}
