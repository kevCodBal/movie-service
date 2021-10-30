package com.proyectoFinal.movieservice.service;

import com.proyectoFinal.movieservice.entity.Movie;
import com.proyectoFinal.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAll(){
        return movieRepository.findAll();

    }


    public Movie getMovieById(int id){
        return movieRepository.findById(id).orElse(null);
    }

    public Movie save(Movie movie){
        Movie movieNew = movieRepository.save(movie);
        return movieNew;
    }

    public List<Movie> byUserId(int userId){
        return movieRepository.findByUserId(userId);
    }


}
