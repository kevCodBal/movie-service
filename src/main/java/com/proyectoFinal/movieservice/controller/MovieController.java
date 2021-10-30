package com.proyectoFinal.movieservice.controller;


import com.proyectoFinal.movieservice.entity.Movie;
import com.proyectoFinal.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
//@RequestMapping("/movie")



public class MovieController {


    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAll(){
        List<Movie> movies = movieService.getAll();

        if (movies.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(movies);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable("id") int id){
        Movie movie = movieService.getMovieById(id);

        if (movie == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(movie);
    }


    @PostMapping()
    public ResponseEntity<Movie> save(@RequestBody Movie movie){
        Movie userNew = movieService.save(movie);

        return ResponseEntity.ok(userNew);
    }


    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Movie>> getByUserId(@PathVariable("userId")int userId){
        List<Movie> movies = movieService.byUserId(userId);

        return ResponseEntity.ok(movies);
    }

}
