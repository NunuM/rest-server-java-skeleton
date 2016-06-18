/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.app.settings;

/**
 *
 * @author nuno
 */
public class AppSettings {
    
    private static final String REP_FACT = "com.company.domain.persistence.jpa.JpaRepositoryFactory";
    private static final String JPA_PU = "com.company_JerseyJPA_jar_1.0PU";
    private static final String SERVER_URI = "http://localhost/";
    private static final int SERVER_PORT = 8080;
    

    private AppSettings() {
    }

    public static AppSettings getInstance() {
        return AppSettingsHolder.INSTANCE;
    }

    public String getRepositoryFactory() {
        return REP_FACT;
    }

    public String getProperty(String PERSISTENCE_UNIT) {
        return JPA_PU;
    }

    public String getServerURI() {
        return SERVER_URI;
    }

    public int getServerPort() {
        return SERVER_PORT;
    }

    private static class AppSettingsHolder {

        private static final AppSettings INSTANCE = new AppSettings();
    }
}
