package com.example.gfl_final_hotel.service;

import com.example.gfl_final_hotel.model.Guest;
import com.example.gfl_final_hotel.repo.GuestReposotory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl {
    private final GuestReposotory guestReposotory;

    public List<Guest> getAllByCheckOut() {

    }
}
