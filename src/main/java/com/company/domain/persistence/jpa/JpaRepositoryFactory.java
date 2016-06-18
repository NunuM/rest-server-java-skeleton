/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.domain.persistence.jpa;

import com.company.domain.persistence.ActorRepository;
import com.company.domain.persistence.MovieRepository;
import com.company.domain.persistence.RepositoryFactory;

/**
 *
 * @author nuno
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public MovieRepository movies() {
        return new JpaMovieRepository();
    }

    @Override
    public ActorRepository actors() {
        return new JpaActorRepository();
    }

}
