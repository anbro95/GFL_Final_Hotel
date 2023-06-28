package com.example.gfl_final_hotel.controller;

import com.example.gfl_final_hotel.model.Room;
import com.example.gfl_final_hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rooms")
public class RoomController {
    private final RoomService roomService;

    @PostMapping("")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        return ResponseEntity.ok().body(roomService.addRoom(room));
    }

    @GetMapping("")
    public ResponseEntity<List<Room>> getAll() {
        return ResponseEntity.ok().body(roomService.getAll());
    }

    @PutMapping("/vacate/{roomId}")
    public ResponseEntity<Room> vacateRoom(@PathVariable Long roomId) {
        return ResponseEntity.ok().body(roomService.vacateRoom(roomId));
    }
}
