package com.vacation_home_backend.vacation_home_backend.service;


import com.vacation_home_backend.vacation_home_backend.model.Stay;
import com.vacation_home_backend.vacation_home_backend.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StayService {

    @Autowired
    StayRepository stayRepository;

    public List<Stay> getStays(){
        return stayRepository.findAll();
    }
}

