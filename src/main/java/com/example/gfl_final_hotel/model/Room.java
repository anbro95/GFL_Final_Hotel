package com.example.gfl_final_hotel.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isAvailable;

    private RoomType type;

    private Integer capacity;

}
