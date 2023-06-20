package com.example.gfl_final_hotel;

import com.example.gfl_final_hotel.model.Room;
import com.example.gfl_final_hotel.model.RoomType;
import com.example.gfl_final_hotel.service.GuestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GflFinalHotelApplication {
    public static void main(String[] args) {
        SpringApplication.run(GflFinalHotelApplication.class, args);
    }

}