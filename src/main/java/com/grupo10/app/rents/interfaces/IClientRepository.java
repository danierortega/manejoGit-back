package com.grupo10.app.rents.interfaces;

import com.grupo10.app.rents.entities.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres
 */
public interface IClientRepository extends CrudRepository<Client, Integer> {
    
}
