
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.entities.Client;

import com.grupo10.app.rents.interfaces.IClientRepository;
import com.grupo10.app.rents.interfaces.IMessageRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    @Autowired
    IClientRepository repository;

    @Autowired
    IMessageRepository messageRepository;
    
    public Iterable<Client> get(){
        Iterable<Client> response = repository.findAll();
        return response;
    }

    public String create(Client request) {

        if (request.getName() != null) {
            repository.save(request);
            return "created....";
        } else {
            return "falta el nombre";
        }

    }
    
    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> e = repository.findById(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getEmail() != null) {
                    e.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                if(client.getAge() != null){
                    e.get().setAge(client.getAge());
                }
                repository.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }
    
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        Boolean delete = true;
        return delete;
    }
    
}
