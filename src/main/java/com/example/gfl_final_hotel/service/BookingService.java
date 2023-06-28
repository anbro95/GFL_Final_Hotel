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
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public Booking createBooking(Booking booking, Long roomId, Long guestId) {
        Room room = roomRepository.findById(roomId).orElseThrow(NoSuchElementException::new);
        Guest guest = guestRepository.findById(guestId).orElseThrow(NoSuchElementException::new);

        if (!room.getIsAvailable()) {
            throw new IllegalArgumentException();
        }

        Duration difference = Duration.between(booking.getDayFrom().atStartOfDay(), booking.getDayTo().atStartOfDay());
        int duration = (int) difference.toDays();

        if (duration < 1) {
            throw new IllegalArgumentException();
        }

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

    public Booking changeDate(Long bookingId, LocalDate date) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(NoSuchElementException::new);

        booking.setDayTo(date);

        Duration difference = Duration.between(booking.getDayFrom().atStartOfDay(), booking.getDayTo().atStartOfDay());
        int duration = (int) difference.toDays();

        if (duration < 1) {
            throw new IllegalArgumentException();
        }

        int sum = (duration * booking.getRoom().getType().price);

        booking.setSum(sum);
        booking = bookingRepository.save(booking);

        ReceiptMaker.createReceipt(booking);
        return booking;

    }
}
