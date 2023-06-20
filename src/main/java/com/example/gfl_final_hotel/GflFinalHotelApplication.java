package com.example.gfl_final_hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GflFinalHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(GflFinalHotelApplication.class, args);

//        ReceiptMaker.createReceipt(new Booking(152L, 3L, 27L, LocalDate.now(), LocalDate.now(), 5200));
    }

}
