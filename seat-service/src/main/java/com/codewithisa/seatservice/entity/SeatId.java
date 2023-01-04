package com.codewithisa.seatservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatId implements Serializable {

    private Character studioName;

    private String nomorKursi;

    private Long scheduleId;
}

