package com.vacation_home_backend.vacation_home_backend.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@NoArgsConstructor  // ✅ Auto-generates default constructor
@AllArgsConstructor // ✅ All-args constructor
@Data
@Table(name = "stays")
public class Stay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "price")
    private Double price;

    @Column(name = "rating")
    private int rating;

    @Column(name = "occupancy")
    private int occupancy;

    @Column(name = "image_url")
    private String imageUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stay stay = (Stay) o;
        return rating == stay.rating && occupancy == stay.occupancy && Objects.equals(id, stay.id) && Objects.equals(name, stay.name) && Objects.equals(description, stay.description) && Objects.equals(address, stay.address) && Objects.equals(price, stay.price) && Objects.equals(imageUrl, stay.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, address, price, rating, occupancy, imageUrl);
    }

}

