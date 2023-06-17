package com.example.gfl_final_hotel.controller;

import com.example.gfl_final_hotel.model.Booking;
import com.example.gfl_final_hotel.service.BookingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookings")
public class BookingController {
    final BookingServiceImpl bookingService;

    @PostMapping("")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok().body(bookingService.createBooking(booking));
    }
}
