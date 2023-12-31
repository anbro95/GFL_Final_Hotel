package com.example.gfl_final_hotel.repo;

import com.example.gfl_final_hotel.model.Booking;
import com.example.gfl_final_hotel.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByFirstName(String firstName);
    List<Guest> findByLastName(String lastName);
    List<Guest> findByEmail(String email);
    List<Guest> findByPassport(String passport);
}
