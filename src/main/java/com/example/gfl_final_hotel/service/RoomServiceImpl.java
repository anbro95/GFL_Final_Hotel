package com.example.gfl_final_hotel.service;

import com.example.gfl_final_hotel.model.Room;
import com.example.gfl_final_hotel.repo.RoomReposotory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl {
    final RoomReposotory roomReposotory;

    public Room addRoom(Room room) {
        return roomReposotory.save(room);
    }
}
