package com.example.gfl_final_hotel.service;

import com.example.gfl_final_hotel.model.Room;
import com.example.gfl_final_hotel.repo.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl {
    private final RoomRepository roomRepository;

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room vacateRoom(Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(NoSuchElementException::new);
        room.setIsAvailable(true);
        return roomRepository.save(room);
    }
}
