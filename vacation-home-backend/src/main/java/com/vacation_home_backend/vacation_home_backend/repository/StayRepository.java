package com.vacation_home_backend.vacation_home_backend.repository;

import com.vacation_home_backend.vacation_home_backend.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StayRepository extends JpaRepository<Stay, Long> {
}
