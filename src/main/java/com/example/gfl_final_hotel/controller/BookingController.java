package com.example.gfl_final_hotel.controller;

import com.example.gfl_final_hotel.model.Booking;
import com.example.gfl_final_hotel.service.BookingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookings")
public class BookingController {
    private final BookingServiceImpl bookingService;

    @PostMapping("")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking, @RequestParam(name = "guestId", required = true) Long guestId,
                                                 @RequestParam(name = "roomId", required = true) Long roomId) {
        return ResponseEntity.ok().body(bookingService.createBooking(booking, roomId, guestId));
    }

    @GetMapping("")
    public ResponseEntity<List<Booking>> getAll() {
        return ResponseEntity.ok().body(bookingService.getAll());
    }
}
