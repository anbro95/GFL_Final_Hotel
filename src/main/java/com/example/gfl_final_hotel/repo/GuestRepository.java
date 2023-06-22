package com.example.gfl_final_hotel.repo;

import com.example.gfl_final_hotel.model.Booking;
import com.example.gfl_final_hotel.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
