/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.app.settings;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author nuno
 */
public class AppSettings {

    private static final String REP_FACT = "com.company.domain.persistence.jpa.JpaRepositoryFactory";
    private static final String JPA_PU = "com.company_JerseyJPA_jar_1.0PU";
    private static final String DEFAULT_SERVER_URI = "http://localhost";
    private static final int DEFAULT_SERVER_PORT = 8080;

    private static final int NOT_FOUND = -1;


    private AppSettings() {
    }

    public synchronized static AppSettings getInstance() {
        return AppSettingsHolder.INSTANCE;
    }

    public String getRepositoryFactory() {
        return REP_FACT;
    }

    public String getProperty(String PERSISTENCE_UNIT) {
        return JPA_PU;
    }

    public String getServerURI() {
        return DEFAULT_SERVER_URI;
    }


    public int getServerPort() {
        int port;

        if ((port = checkValue(System.getenv("SERVER_PORT"))) != NOT_FOUND) {
            return port;
        }

        if ((port = checkValue(System.getProperty("app.server.port"))) != NOT_FOUND) {
            return port;
        }

        return DEFAULT_SERVER_PORT;
    }

    private static class AppSettingsHolder {

        private static final AppSettings INSTANCE = new AppSettings();
    }

    private Integer checkValue(String value) {
        if (value != null) {
            try {
                return Integer.valueOf(System.getenv("SERVER_PORT"));
            } catch (NumberFormatException e) {
                // Ignore
            }
        }
        return NOT_FOUND;
    }
}


