package com.example.gfl_final_hotel.model;

public enum RoomType {
    STANDARD(1200),
    SUIT(1800),
    DELUXE(2500);

    public final int price;

    private RoomType(int price) {
        this.price = price;
    }
}
