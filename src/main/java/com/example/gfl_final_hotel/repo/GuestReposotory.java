package com.example.gfl_final_hotel.repo;

import com.example.gfl_final_hotel.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestReposotory extends JpaRepository<Guest, Long> {
}
