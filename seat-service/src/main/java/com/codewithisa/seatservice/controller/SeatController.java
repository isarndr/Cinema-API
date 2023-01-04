package com.codewithisa.seatservice.controller;

import com.codewithisa.seatservice.entity.Seat;
import com.codewithisa.seatservice.service.SeatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    SeatService seatService;

    @PostMapping("/")
    public ResponseEntity<Seat> saveSeat(@RequestBody Seat seat) {
        seatService.saveSeat(seat);
        return new ResponseEntity<>(seat, HttpStatus.CREATED);
    }

    @Operation(summary = "untuk mendapatkan seats berdasarkan schedule id")
    @GetMapping("/seats-by-schedule-id/{scheduleId}")
    public ResponseEntity<?> findSeatsByScheduleId(@Schema(example = "1") @PathVariable("scheduleId") Long scheduleId){
        return new ResponseEntity<>(seatService.findSeatsByScheduleId(scheduleId), HttpStatus.OK);
    }

    @DeleteMapping("/by-schedule-id-and-nomor-kursi")
    public ResponseEntity<String> deleteSeatByScheduleIdAndNomorKursi(@RequestParam("scheduleId") Long scheduleId,
                                                                      @RequestParam("nomorKursi") String nomorKursi){
        try {
            seatService.deleteSeatByScheduleIdAndNomorKursi(scheduleId, nomorKursi);
            return new ResponseEntity<>("Seat deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/by-schedule-id-and-nomor-kursi")
    public ResponseEntity<?> findSeatByScheduleIdAndNomorKursi(@RequestParam("scheduleId") Long scheduleId,
                                                                  @RequestParam("nomorKursi") String nomorKursi){
        try {
            return new ResponseEntity<>(seatService.findSeatByScheduleIdAndNomorKursi(scheduleId, nomorKursi), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
