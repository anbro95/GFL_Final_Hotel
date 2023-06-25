package com.example.gfl_final_hotel.service;

import com.example.gfl_final_hotel.model.Room;
import com.example.gfl_final_hotel.repo.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl {
    private final RoomRepository roomRepository;

    public Room addRoom(Room room) {
        room.setIsAvailable(true);
        return roomRepository.save(room);
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Room vacateRoom(Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(NoSuchElementException::new);
        room.setIsAvailable(true);
        return roomRepository.save(room);
    }
}
