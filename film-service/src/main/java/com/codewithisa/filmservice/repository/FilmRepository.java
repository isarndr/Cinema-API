package com.codewithisa.filmservice.repository;

import com.codewithisa.filmservice.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
    @Query(
            nativeQuery = true,
            value = "select * from films where film_code=:filmCode"
    )
    Film findFilmByFilmCode(@Param("filmCode") Long filmCode);

    @Transactional
    @Modifying
    @Query(
            nativeQuery = true,
            value = "delete from films where film_code = :filmCode"
    )
    void deleteFilmByFilmCode(@Param("filmCode") Long filmCode);

    @Query(
            nativeQuery = true,
            value = "select * from films where sedang_tayang = true"
    )
    List<Film> findFilmsYangSedangTayang();

    @Query(
            nativeQuery = true,
            value = "select * from films where film_name = :filmName"
    )
    Film findFilmByFilmName(@Param("filmName") String filmName);

    Boolean existsByFilmName(String filmName);

    @Query(
            nativeQuery = true,
            value = "select * from films where sedang_tayang = true"
    )
    Page<Film> findFilmsYangSedangTayang(PageRequest pageRequest);
}

