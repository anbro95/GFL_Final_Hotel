package com.example.gfl_final_hotel.service;

import com.example.gfl_final_hotel.model.Booking;
import com.example.gfl_final_hotel.model.Guest;
import com.example.gfl_final_hotel.repo.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl {
    private final GuestRepository guestRepository;
    private final BookingServiceImpl bookingService;

    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public List<Guest> getAllByCheckOut() {
        List<Booking> list = bookingService.getAll().stream().filter(b -> LocalDate.now().equals(b.getDayTo())).toList();
        return list.stream().map(Booking::getGuest).toList();
    }
}
