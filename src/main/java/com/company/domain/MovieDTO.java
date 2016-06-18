/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.domain;

import com.company.framework.dto.DTO;
import java.util.Calendar;
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
@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class MovieDTO implements DTO {

    @XmlElement
    private String name;

    @XmlElement
    private Calendar realeaseOn;

    public MovieDTO() {
    }
    
    public MovieDTO(Movie aThis) {
        this.name = aThis.getName();
        this.realeaseOn = aThis.getRealeaseOn();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Calendar getRealeaseOn() {
        return realeaseOn;
    }

    public void setRealeaseOn(Calendar realeaseOn) {
        this.realeaseOn = realeaseOn;
    }

    @Override
    public Map<String, Object> dtoValues() {
        Map<String, Object> map = new HashMap<>();

        map.put("name", name);
        map.put("realeaseOn", realeaseOn);

        return map;
    }

}
