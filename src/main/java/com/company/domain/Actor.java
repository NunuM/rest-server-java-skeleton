/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.domain;

import com.company.framework.domain.DomainEntity;
import com.company.framework.dto.DTOable;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nuno
 */
@Entity
public class Actor implements DomainEntity<Long>,Serializable,DTOable{
    
    private static final long serialVersionUID = 2l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true, length = 100)
    private String name;
    

    protected Actor() {
        //For Jpa
    }
    

    public Actor(String name) {
        this.setName(name);
    }
    
    @Override
    public Long id() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean is(Long id) {
        return this.id.equals(id);
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
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
        final Actor other = (Actor) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "Actor{" + "id=" + id + ", name=" + name + '}';
    }
    
    
    @Override
    public ActorDTO toDTO(Object arg) {
    return new ActorDTO(this);
    }

}
