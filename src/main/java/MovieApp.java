
import com.company.app.settings.AppSettings;
import com.company.application.ActorManagementController;
import com.company.application.MovieManagmentController;
import com.company.domain.Actor;
import com.company.domain.ActorDTO;
import com.company.domain.Movie;
import com.company.domain.MovieDTO;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.net.URI;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


/**
 * @author nuno
 */
public class MovieApp {

    private static final String BASE_URI = String.format("%s:%s", AppSettings.getInstance().getServerURI(), AppSettings.getInstance().getServerPort());

    public static void main(String[] args) {

        // Uniform logging
        LogManager.getLogManager().reset();
        SLF4JBridgeHandler.install();

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


            MovieApp.startServer();

            System.out.println("Your server is running at: " + BASE_URI);

            new Scanner(System.in).nextLine();

        } catch (Exception e) {
            Logger.getLogger(MovieApp.class.getName()).log(Level.SEVERE, "Something went wrong ", e);
        }

    }


    private static HttpServer startServer() {

        // create a resource config that scans for JAX-RS resources and providers
        // in com.company.rest.facades package
        final ResourceConfig rc = new ResourceConfig().packages("com.company.rest.facades");

        rc.register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        rc.property(LoggingFeature.LOGGING_FEATURE_VERBOSITY, LoggingFeature.Verbosity.PAYLOAD_ANY);
        rc.property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL, Level.INFO.getName());

        rc.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        rc.property(ServerProperties.MONITORING_STATISTICS_ENABLED, true);

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

}
