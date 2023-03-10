package com.codewithisa.scheduleservice.repository;

import com.codewithisa.scheduleservice.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(
            nativeQuery = true,
            value = "select * from schedules where schedule_id=:scheduleId"
    )
    Schedule findScheduleByScheduleId(@Param("scheduleId") Long scheduleId);

    @Query(
            nativeQuery = true,
            value = "select * from schedules where film_code=:film_code"
    )
    List<Schedule> findSchedulesByFilmCode(@Param("film_code") Long film_code);

    @Transactional
    @Modifying
    @Query(
            nativeQuery = true,
            value = "delete from schedules where schedule_id = :scheduleId"
    )
    void deleteScheduleByScheduleId(@Param("scheduleId") Long scheduleId);

    @Query(
            nativeQuery = true,
            value = "select * from schedules " +
                    "where jam_mulai=:jamMulai and studio_name=:studioName and tanggal_tayang=:tanggalTayang and " +
                    "film_code=:filmCode")
    Schedule findScheduleByJamMulaiAndStudioNameAndTanggalTayangAndFilmCode(
            @Param("jamMulai") String jamMulai,
            @Param("studioName") Character studioName,
            @Param("tanggalTayang") String tanggalTayang,
            @Param("filmCode") Long filmCode
    );

    Boolean existsByFilmCode(Long filmCode);
}

