package com.company.domain.persistence;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.company.app.settings.AppSettings;

/**
 * provides easy access to the persistence layer
 * <p>
 * works as a factory of factories
 *
 * @author nuno
 */
public final class PersistenceContext {

    private PersistenceContext() {
    }

    /**
     * Dinamycally creates a repository factory.
     *
     * @return A concrete implementation of RepositoryFactory
     */
    public static RepositoryFactory repositories() {
        final String factoryClassName = AppSettings.getInstance().getRepositoryFactory();
        try {
            return (RepositoryFactory) Class.forName(factoryClassName).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            // FIXME handle exception properly
            Logger.getLogger(PersistenceContext.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
