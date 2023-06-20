package com.example.gfl_final_hotel.controller;


import com.example.gfl_final_hotel.model.Guest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/guests")
public class GuestController {

    @GetMapping("")
    public ResponseEntity<List<Guest>> getAllByCheckOut() {

    }
}
