package com.vacation_home_backend.vacation_home_backend.service;


import com.vacation_home_backend.vacation_home_backend.model.Stay;
import com.vacation_home_backend.vacation_home_backend.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StayService {

    @Autowired
    StayRepository stayRepository;

    public List<Stay> getStays(){
        return stayRepository.findAll();
    }

    public Optional<Stay> getStay(Long id) {
        return stayRepository.findById(id);
    }
}

