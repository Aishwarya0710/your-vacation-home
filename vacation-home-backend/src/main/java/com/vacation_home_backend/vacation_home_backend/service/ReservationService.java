package com.vacation_home_backend.vacation_home_backend.service;


import com.vacation_home_backend.vacation_home_backend.model.StayEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ReservationService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String reserveStay(Long stayId, String stayName) {
        // TODO: Save reservation to DB
        System.out.println("im here ");

        // 🔥 Send booking event to Kafka
      //  StayEvent event = new StayEvent(stayId, stayName, "booked", System.currentTimeMillis());
        kafkaTemplate.send("stay-events", "I have booked the stay "+stayId);

         return "Reservation Done Successfully!";
    }
}
