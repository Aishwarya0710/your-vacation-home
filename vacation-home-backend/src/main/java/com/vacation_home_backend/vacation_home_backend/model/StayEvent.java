package com.vacation_home_backend.vacation_home_backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StayEvent {

    private Long stayId;
    private String stayName;
    private String action;
    private Long timestamp;

}
