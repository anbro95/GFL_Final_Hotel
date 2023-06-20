package com.example.gfl_final_hotel.service;


import com.example.gfl_final_hotel.model.Booking;
import com.example.gfl_final_hotel.model.Guest;
import com.example.gfl_final_hotel.model.Room;
import com.example.gfl_final_hotel.repo.BookingRepository;
import com.example.gfl_final_hotel.repo.GuestReposotory;
import com.example.gfl_final_hotel.repo.RoomReposotory;
import com.example.gfl_final_hotel.utils.ReceiptMaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl {
    private final BookingRepository bookingRepository;
    private final RoomReposotory roomReposotory;
    private final GuestReposotory guestReposotory;

    public Booking createBooking(Booking booking) {
        Room room = roomReposotory.findById(booking.getRoomId()).orElse(null);
        if (room == null || !room.getIsAvailable())
            throw new NoSuchElementException();

        guestReposotory.save(new Guest(booking.getGuestId(), null, null, null));

//        Guest guest = guetReposotory.findById(booking.getGuestId()).orElse(null);
//        if (guest == null)
//            throw new NoSuchElementException();


        room.setIsAvailable(false);
        roomReposotory.save(room);

        Duration difference = Duration.between(booking.getDayFrom().atStartOfDay(), booking.getDayTo().atStartOfDay());
        int duration = (int) difference.toDays();

        int sum = (duration * room.getType().price);

        booking.setSum(sum);

        booking = bookingRepository.save(booking);
        ReceiptMaker.createReceipt(booking);
        return booking;
    }

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }
}
