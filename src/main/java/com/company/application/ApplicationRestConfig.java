/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.application;

import com.company.rest.facades.ActorFacade;
import com.company.rest.facades.MovieFacade;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author nuno
 */
public class ApplicationRestConfig extends Application{
    
    /**
     * Get classes to be used in Rest
     *
     * @return classes to Rest
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Add Facades classes
     *
     * @param resources classes to add
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(MovieFacade.class);
        resources.add(ActorFacade.class);

    }


}
