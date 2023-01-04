package com.codewithisa.seatservice.service;

import com.codewithisa.seatservice.entity.Seat;
import com.codewithisa.seatservice.repository.SeatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SeatServiceImpl implements SeatService{

    @Autowired
    SeatRepository seatRepository;

    @Override
    public void saveSeat(Seat seat) {
        seatRepository.save(seat);
        log.info("seat successfully added");
    }

    @Override
    public List<Seat> findSeatsByScheduleId(Long scheduleId){

        Boolean existByScheduleId = existByScheduleId(scheduleId);

        if(!existByScheduleId){
            log.info("seats are fully booked");
            return new ArrayList<>();
        }

        return seatRepository.findSeatsByScheduleId(scheduleId);
    }

    @Override
    public void deleteSeatByScheduleIdAndNomorKursi(Long scheduleId, String nomorKursi) throws Exception{

        Boolean existByScheduleId = existByScheduleId(scheduleId);

        if(!existByScheduleId){
            log.error("schedule id is not in the database");
            throw new Exception("schedule id is not in the database");
        }

        Boolean existsByNomorKursi = existsByNomorKursi(nomorKursi);

        if(!existsByNomorKursi){
            log.error("nomor kursi is not in the database");
            throw new Exception("nomor kursi is not in the database");
        }

        seatRepository.deleteSeatByScheduleIdAndNomorKursi(scheduleId, nomorKursi);
    }

    @Override
    public Seat findSeatByScheduleIdAndNomorKursi(Long scheduleId, String nomorKursi) throws Exception{

        Boolean existByScheduleId = existByScheduleId(scheduleId);

        if(!existByScheduleId){
            log.error("schedule id is not in the database");
            throw new Exception("schedule id is not in the database");
        }

        Boolean existsByNomorKursi = existsByNomorKursi(nomorKursi);

        if(!existsByNomorKursi){
            log.error("nomor kursi is not in the database");
            throw new Exception("nomor kursi is not in the database");
        }

        return seatRepository.findSeatByScheduleIdAndNomorKursi(scheduleId, nomorKursi);
    }

    @Override
    public Boolean existByScheduleId(Long scheduleId) {
        return seatRepository.existsByScheduleId(scheduleId);
    }

    @Override
    public Boolean existsByNomorKursi(String nomorKursi) {
        return seatRepository.existsByNomorKursi(nomorKursi);
    }
}

