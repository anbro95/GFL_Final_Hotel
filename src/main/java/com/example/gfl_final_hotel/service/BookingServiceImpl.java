package com.example.gfl_final_hotel.service;

import com.example.gfl_final_hotel.model.Booking;
import com.example.gfl_final_hotel.model.Guest;
import com.example.gfl_final_hotel.model.Room;
import com.example.gfl_final_hotel.repo.BookingRepository;
import com.example.gfl_final_hotel.repo.GuestRepository;
import com.example.gfl_final_hotel.repo.RoomRepository;
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
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public Booking createBooking(Booking booking, Long roomId, Long guestId) {
        Room room = roomRepository.findById(roomId).orElse(null);
        Guest guest = guestRepository.findById(guestId).orElse(null);

        if (room == null || guest == null)
            throw new NoSuchElementException();

        Duration difference = Duration.between(booking.getDayFrom().atStartOfDay(), booking.getDayTo().atStartOfDay());
        int duration = (int) difference.toDays();

        int sum = (duration * room.getType().price);

        booking.setSum(sum);

        room.setIsAvailable(false);
        booking.setRoom(room);
        booking.setGuest(guest);
        roomRepository.save(room);

        booking = bookingRepository.save(booking);

        ReceiptMaker.createReceipt(booking);
        return booking;
    }

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }
}
