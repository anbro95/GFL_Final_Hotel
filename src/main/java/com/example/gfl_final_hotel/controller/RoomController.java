package com.example.gfl_final_hotel.controller;

import com.example.gfl_final_hotel.model.Room;
import com.example.gfl_final_hotel.service.RoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rooms")
public class RoomController {
    private final RoomServiceImpl roomService;

    @PostMapping("")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        return ResponseEntity.ok().body(roomService.addRoom(room));
    }
}
