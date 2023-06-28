package com.example.gfl_final_hotel.controller;

import com.example.gfl_final_hotel.model.Booking;
import com.example.gfl_final_hotel.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookings")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking, @RequestParam(name = "guestId", required = true) Long guestId,
                                                 @RequestParam(name = "roomId", required = true) Long roomId) {
        try {
            return ResponseEntity.ok().body(bookingService.createBooking(booking, roomId, guestId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(403).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(403).build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Booking>> getAll() {
        return ResponseEntity.ok().body(bookingService.getAll());
    }

    @PutMapping("/booking/{bookingId}/changeDate")
    public ResponseEntity<Booking> changeDate(@PathVariable Long bookingId, @RequestParam(required =true)LocalDate date) {
        try {
            return ResponseEntity.ok().body(bookingService.changeDate(bookingId, date));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(403).build();
        }
    }
}
