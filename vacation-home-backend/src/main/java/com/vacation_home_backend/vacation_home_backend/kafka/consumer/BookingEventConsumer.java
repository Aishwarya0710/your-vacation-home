package com.vacation_home_backend.vacation_home_backend.kafka.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookingEventConsumer {

    @KafkaListener(topics = "stay-events", groupId = "stay-group")
    public void consume(String message) {
        System.out.println("Message received: " + message);
    }
}
