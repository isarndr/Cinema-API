package com.codewithisa.seatservice.repository;

import com.codewithisa.seatservice.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {

    @Query(
            nativeQuery = true,
            value = "select * from seats where schedule_id = :scheduleId"
    )
    List<Seat> findSeatsByScheduleId(@RequestParam("scheduleId") Long scheduleId);

    @Modifying
    @Transactional
    @Query(
            nativeQuery = true,
            value = "delete from seats where schedule_id = :scheduleId and nomor_kursi = :nomorKursi"
    )
    void deleteSeatByScheduleIdAndNomorKursi(@Param("scheduleId") Long scheduleId, @Param("nomorKursi") String nomorKursi);

    @Query(
            nativeQuery = true,
            value = "select * from seats where schedule_id=:scheduleId and nomor_kursi=:nomorKursi"
    )
    Seat findSeatByScheduleIdAndNomorKursi(@Param("scheduleId") Long scheduleId, @Param("nomorKursi") String nomorKursi);

    Boolean existsByScheduleId(Long scheduleId);

    Boolean existsByNomorKursi(String nomorKursi);
}

