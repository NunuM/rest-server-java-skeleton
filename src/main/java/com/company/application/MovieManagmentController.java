/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.application;

import com.company.domain.Actor;
import com.company.domain.ActorDTO;
import com.company.domain.Movie;
import com.company.domain.MovieDTO;
import com.company.domain.persistence.ActorRepository;
import com.company.domain.persistence.MovieRepository;
import com.company.domain.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author nuno
 */
public class MovieManagmentController {

    private final MovieRepository movieRepository;

    public MovieManagmentController() {
        this.movieRepository = PersistenceContext.repositories().movies();
    }

    public boolean addNewMovie(MovieDTO movieDTO) {

        Movie movie = new Movie(movieDTO.getName(), movieDTO.getRealeaseOn());

        Movie save = movieRepository.save(movie);

        return true;
    }

    public List<MovieDTO> movieList() {

        List<MovieDTO> list = new ArrayList<>();

        Iterable<Movie> all = movieRepository.all();
        Iterator<Movie> iterator = all.iterator();

        while (iterator.hasNext()) {
            list.add(iterator.next().toDTO(null));
        }

        return list;
    }

}
