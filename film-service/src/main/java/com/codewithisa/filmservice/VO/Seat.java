package com.codewithisa.filmservice.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {
    private Character studioName;
    private String nomorKursi;
    private Long scheduleId;
}
