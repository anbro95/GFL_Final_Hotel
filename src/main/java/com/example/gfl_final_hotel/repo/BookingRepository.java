package com.example.gfl_final_hotel.repo;

import com.example.gfl_final_hotel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
