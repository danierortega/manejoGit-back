package com.grupo10.app.rents.interfaces;

import com.grupo10.app.rents.entities.Client;
import org.springframework.data.repository.CrudRepository;


public interface IClientRepository extends CrudRepository<Client, Integer> {
    
}
