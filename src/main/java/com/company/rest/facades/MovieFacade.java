/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.rest.facades;

import com.company.application.MovieManagmentController;
import com.company.domain.MovieDTO;
import com.sun.istack.internal.logging.Logger;
import java.util.List;
import java.util.logging.Level;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author nuno
 */
@Path("movie")
public class MovieFacade {

    private static String ERROR_MSG = "Something was wrong, try later";

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response allMovies() {

        try {

            MovieManagmentController movieManagmentController = new MovieManagmentController();
            List<MovieDTO> movieList = movieManagmentController.movieList();

            GenericEntity<List<MovieDTO>> entity = new GenericEntity<List<MovieDTO>>(movieList) {};
            
            return Response.ok(entity).build();

        } catch (Exception e) {

            Logger.getLogger(MovieFacade.class).log(Level.SEVERE,
                    "Unable to return list of movies to database:", e);

            return Response.ok(ERROR_MSG).build();
        }

    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response newMovie(MovieDTO movieDTO) {

        try {

            MovieManagmentController movieManagmentController = new MovieManagmentController();

            movieManagmentController.addNewMovie(movieDTO);

            return Response.ok().build();

        } catch (Exception e) {

            Logger.getLogger(MovieFacade.class).log(Level.SEVERE,
                    "Unable to return add movie to database:", e);

            return Response.ok(ERROR_MSG).build();
        }

    }
}
