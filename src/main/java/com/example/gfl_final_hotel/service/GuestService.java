package com.example.gfl_final_hotel.service;

import com.example.gfl_final_hotel.model.Booking;
import com.example.gfl_final_hotel.model.Guest;
import com.example.gfl_final_hotel.repo.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;
    private final BookingService bookingService;

    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public List<Guest> getAllByCheckOut() {
        List<Booking> list = bookingService.getAll().stream().filter(b -> LocalDate.now().equals(b.getDayTo())).toList();
        return list.stream().map(Booking::getGuest).toList();
    }

    public List<Guest> getByParams(Long id, String firstName, String lastName, String email, String passport) {
        if (id != null)
            return List.of(guestRepository.findById(id).orElse(null));
        else if (firstName != null)
            return guestRepository.findByFirstName(firstName);
        else if (lastName != null)
            return guestRepository.findByLastName(lastName);
        else if (email != null)
            return guestRepository.findByEmail(email);
        else if (passport != null)
            return guestRepository.findByPassport(passport);

        else
            return guestRepository.findAll();
    }
}
