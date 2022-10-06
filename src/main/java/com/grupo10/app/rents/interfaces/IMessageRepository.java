package com.grupo10.app.rents.interfaces;

import com.grupo10.app.rents.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface IMessageRepository extends CrudRepository<Message, Integer> {
    
}
