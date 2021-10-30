package com.proyectoFinal.movieservice.repository;

import com.proyectoFinal.movieservice.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findByUserId(int userId);
}
