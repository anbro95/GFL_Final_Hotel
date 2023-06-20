package com.example.gfl_final_hotel.service;

import com.example.gfl_final_hotel.model.Room;
import com.example.gfl_final_hotel.repo.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl {
    private final RoomRepository roomRepository;

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }
}
