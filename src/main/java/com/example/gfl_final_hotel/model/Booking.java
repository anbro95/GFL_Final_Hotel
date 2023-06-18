package com.example.gfl_final_hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long guestId;
    private Long roomId;

    @Column(columnDefinition = "DATE")
    private LocalDate dayFrom;
    @Column(columnDefinition = "DATE")
    private LocalDate dayTo;

    private Integer sum;
}
