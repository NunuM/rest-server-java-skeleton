/**
 *
 */
package com.company.domain.persistence;

/**
 * @author nuno
 */
public interface RepositoryFactory {
    MovieRepository movies();
    
    ActorRepository actors();
    
}
