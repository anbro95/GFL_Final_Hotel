package com.example.gfl_final_hotel.controller;


import com.example.gfl_final_hotel.model.Guest;
import com.example.gfl_final_hotel.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/guests")
public class GuestController {
    private final GuestService guestService;

    @PostMapping("")
    public ResponseEntity<Guest> saveGuest(@RequestBody Guest guest) {
        return ResponseEntity.ok().body(guestService.saveGuest(guest));
    }

    @GetMapping("/checkout/today")
    public ResponseEntity<List<Guest>> getAllByCheckOut() {
        return ResponseEntity.ok().body(guestService.getAllByCheckOut());
    }

    @GetMapping("")
    public ResponseEntity<List<Guest>> getByParams(@RequestParam(required = false) Long id,
                                                   @RequestParam(required = false) String firstName,
                                                   @RequestParam(required = false) String lastName,
                                                   @RequestParam(required = false) String email,
                                                   @RequestParam(required = false) String passport) {

        return ResponseEntity.ok().body(guestService.getByParams(id, firstName, lastName, email, passport));
    }
}
