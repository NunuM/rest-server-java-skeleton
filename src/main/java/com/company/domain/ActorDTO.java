/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.domain;

import com.company.framework.dto.DTO;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nuno
 */
@XmlRootElement(name = "actor")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActorDTO implements DTO {

    @XmlElement
    private String name;

    public ActorDTO() {
    }
    
    public ActorDTO(Actor aThis) {
        name = aThis.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Map<String, Object> dtoValues() {
        HashMap<String, Object> map = new HashMap<>();

        map.put("name", name);

        return map;
    }

}
