/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.rest.facades;

import com.company.application.ActorManagementController;
import com.company.domain.ActorDTO;
import io.swagger.annotations.Api;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Api("actor")
@Path("actor")
public class ActorFacade {

    private static String ERROR_MSG = "Something was wrong, try later";

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response allActors() {

        try {

            final ActorManagementController actorManagementController = new ActorManagementController();
            List<ActorDTO> actorsList = actorManagementController.actorsList();
            
            GenericEntity<List<ActorDTO>> entity = new GenericEntity<List<ActorDTO>>(actorsList) {};
            
            return Response.ok(entity).build();

        } catch (Exception ex) {
            Logger.getLogger(ActorFacade.class.getName()).log(Level.SEVERE,
                    "Unable to return list of actors due the following error:", ex);

            return Response.ok(ERROR_MSG).build();
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response newActor(ActorDTO actor) {

        try {

            final ActorManagementController actorManagementController = new ActorManagementController();
            actorManagementController.addNewActor(actor);
            return Response.ok().build();

        } catch (Exception ex) {
            Logger.getLogger(ActorFacade.class.getName()).log(Level.SEVERE,
                    "Unable to return add actors to database:", ex);

            return Response.ok(ERROR_MSG).build();
        }

    }

}
