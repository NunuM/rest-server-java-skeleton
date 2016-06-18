/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.domain.persistence.jpa;

import com.company.app.settings.AppSettings;

/**
 *
 * @author nuno
 */
public class PersistenceSettings {
    
    private static String PERSISTENCE_UNIT = "persistence.unit";
    protected static final String PERSISTENCE_UNIT_NAME = getPersistenceUnit();

    /**
     * Hiding implicit default constructor.
     */
    private PersistenceSettings() {
    }

    private static String getPersistenceUnit() {
        return AppSettings.getInstance().getProperty(PERSISTENCE_UNIT);
    }
    
}
