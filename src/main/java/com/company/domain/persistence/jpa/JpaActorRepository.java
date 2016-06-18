/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.domain.persistence.jpa;

import com.company.framework.persistence.repositories.impl.jpa.JpaRepository;
import com.company.domain.Actor;
import com.company.domain.persistence.ActorRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;

/**
 *
 * @author nuno
 */
public class JpaActorRepository extends JpaRepository<Actor, Long> implements ActorRepository {

    @Override
    protected String persistenceUnitName() {
        return PersistenceSettings.PERSISTENCE_UNIT_NAME;
    }

    @Override
    public Actor getActorByName(String name) {
        
        List<Actor> collect = all().stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
        
        if(!collect.isEmpty())        
                return collect.stream().findFirst().get();
                
        return null;
        
    }
}
