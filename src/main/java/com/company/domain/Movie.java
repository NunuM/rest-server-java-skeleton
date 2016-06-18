/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.domain;

import com.company.framework.domain.DomainEntity;
import com.company.framework.dto.DTOable;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nuno
 */
@Entity
public class Movie implements DomainEntity<Long>, DTOable, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true, length = 100)
    private String name;
    
    @Temporal(TemporalType.DATE)
    private Calendar realeaseOn;
    
    protected Movie() {
        //For JPA
    }
    
    public Movie(String name, Calendar realeaseOn) {
        this.setName(name);
        this.setRealeaseOn(realeaseOn);
    }
    
    @Override
    public Long id() {
        return id;
    }
    
    private void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    private void setName(String name) {
        this.name = name;
    }
    
    
    public Calendar getRealeaseOn() {
        return realeaseOn;
    }
    
    private void setRealeaseOn(Calendar realeaseOn) {
        this.realeaseOn = realeaseOn;
    }
    
    @Override
    public boolean is(Long id) {
        return this.id.equals(id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.realeaseOn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", realeaseOn=" + realeaseOn + '}';
    }

    @Override
    public MovieDTO toDTO(Object arg) {
       return new MovieDTO(this);
    }

    
}
