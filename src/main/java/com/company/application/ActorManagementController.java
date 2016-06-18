/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.application;

import com.company.domain.Actor;
import com.company.domain.ActorDTO;
import com.company.domain.persistence.ActorRepository;
import com.company.domain.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author nuno
 */
public class ActorManagementController {

    private ActorRepository actorRepository;

    public ActorManagementController() {
        this.actorRepository = PersistenceContext.repositories().actors();
    }

    public boolean addNewActor(ActorDTO actorDto) {

        Actor actor = new Actor(actorDto.getName());

        Actor save = actorRepository.save(actor);

        return true;
    }

    public List<ActorDTO> actorsList() {
        List<ActorDTO> list = new ArrayList<>();

        Iterable<Actor> all = actorRepository.all();
        Iterator<Actor> iterator = all.iterator();

        while (iterator.hasNext()) {
            list.add(iterator.next().toDTO(null));
        }

        return list;
    }

}
