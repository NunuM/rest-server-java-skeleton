
import com.company.app.settings.AppSettings;
import com.company.application.ActorManagementController;
import com.company.application.ApplicationRestConfig;
import com.company.application.MovieManagmentController;
import com.company.domain.Actor;
import com.company.domain.ActorDTO;
import com.company.domain.Movie;
import com.company.domain.MovieDTO;
import com.company.framework.RESTServer.HTTPRestServer;
import com.sun.istack.internal.logging.Logger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nuno
 */
public class MovieApp {

    public static void main(String[] args) {

        try {

            // **************  Some bootstrap *****************
            
            Actor actress1 = new Actor("Megan Fox");
            ActorDTO actress1DTO = actress1.toDTO(null);

            Actor actress2 = new Actor("Emma Watson");
            ActorDTO actress2DTO = actress2.toDTO(null);

            
            Actor actress3 = new Actor("Jessica Alba");
            ActorDTO actress3DTO = actress3.toDTO(null);
         
            ActorManagementController actorManagementController = new ActorManagementController();
            
            actorManagementController.addNewActor(actress3DTO);
            actorManagementController.addNewActor(actress2DTO);
            actorManagementController.addNewActor(actress1DTO);
            
            //---
            MovieManagmentController movieManagmentController = new MovieManagmentController();

           
            Calendar nowDate = Calendar.getInstance();

            Movie movie = new Movie("Teenage Mutant Ninja Turtles: Out of the Shadows", nowDate);

            MovieDTO movieDTO = movie.toDTO(null);

            movieManagmentController.addNewMovie(movieDTO);

           
            
            Movie movie1 = new Movie("The Amazing Spider-Man", Calendar.getInstance());
            MovieDTO movie1DTO = movie1.toDTO(null);

            movieManagmentController.addNewMovie(movie1DTO);

            // **************  end bootstrap *****************
            
            
            
            ApplicationRestConfig applicationRestConfig = new ApplicationRestConfig();

            new HTTPRestServer(AppSettings.getInstance().getServerURI(),
                    AppSettings.getInstance().getServerPort())
                    .startServer(applicationRestConfig);

        } catch (Exception e) {
            System.out.println(e);
            Logger.getLogger(MovieApp.class).log(Level.SEVERE, "Something went wrong ", e);
        }

    }

}
