package com.example.gfl_final_hotel.service;


import com.example.gfl_final_hotel.model.Booking;
import com.example.gfl_final_hotel.repo.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl {
    final BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
}
