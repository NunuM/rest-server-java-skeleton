/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.domain.persistence.jpa;

import com.company.domain.Movie;
import com.company.domain.persistence.MovieRepository;
import com.company.framework.persistence.repositories.impl.jpa.JpaRepository;

/**
 *
 * @author nuno
 */
public class JpaMovieRepository extends JpaRepository<Movie, Long> implements MovieRepository{

    @Override
    protected String persistenceUnitName() {
        return PersistenceSettings.PERSISTENCE_UNIT_NAME;
    }
    
}
