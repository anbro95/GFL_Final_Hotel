package com.example.gfl_final_hotel.controller;


import com.example.gfl_final_hotel.model.Guest;
import com.example.gfl_final_hotel.service.GuestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.hibernate.action.internal.UnresolvedEntityInsertActions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/guests")
public class GuestController {
    private final GuestServiceImpl guestService;

    @PostMapping("")
    public ResponseEntity saveGuest(@RequestBody Guest guest) {
        return ResponseEntity.ok().body(guestService.saveGuest(guest));
    }

    @GetMapping("")
    public ResponseEntity<List<Guest>> getAllByCheckOut() {
        return ResponseEntity.ok().body(guestService.getAllByCheckOut());
    }
}
