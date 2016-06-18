/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.domain.persistence;

import com.company.domain.Actor;
import com.company.framework.persistence.repositories.Repository;

/**
 *
 * @author nuno
 */
public interface ActorRepository extends Repository<Actor, Long> {
    
    Actor getActorByName(String name);
    
}
