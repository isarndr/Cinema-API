package com.codewithisa.seatservice.service;

import com.codewithisa.seatservice.entity.Seat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeatService {
    void saveSeat(Seat seat);
    List<Seat> findSeatsByScheduleId(Long scheduleId);
    void deleteSeatByScheduleIdAndNomorKursi(Long scheduleId, String nomorKursi) throws Exception;
    Seat findSeatByScheduleIdAndNomorKursi(Long scheduleId, String nomorKursi) throws Exception;
    Boolean existByScheduleId(Long scheduleId);

    Boolean existsByNomorKursi(String nomorKursi);
}
