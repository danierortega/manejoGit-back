
package com.grupo10.app.rents.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.entities.Message;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.interfaces.IClientRepository;
import com.grupo10.app.rents.interfaces.IMessageRepository;
import com.grupo10.app.rents.interfaces.IQuadbikeRepository;


@Service
public class MessageService {

    @Autowired
    IMessageRepository repository;

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    IQuadbikeRepository quadbikeRepository;

    public Iterable<Message> get(){

        Iterable<Message> response = repository.findAll();

        return response;
    }

    public String create(Message request){
        Optional<Client> cl = clientRepository.findById(request.getClient().getIdClient());
        Optional<Quadbike> qua = quadbikeRepository.findById(request.getQuadbike().getId());
        if(!qua.isEmpty()){
            request.setQuadbike(qua.get());
        }
        if(!cl.isEmpty()){
            request.setClient(cl.get());
        }
        if(request.getMessageText()!=null){
           repository.save(request);
            return "Created ...";
            
        }else{
            return "Falta el nombre";
        }
        
    }
    
    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> e = repository.findById(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText() != null) {
                    e.get().setMessageText(message.getMessageText());
                }
                if (message.getQuadbike() != null) {
                    e.get().setQuadbike(message.getQuadbike());
                }
                if (message.getClient() != null) {
                    e.get().setClient(message.getClient());
                }
                repository.save(e.get());
                return e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public Boolean delete(Integer id) {
        repository.deleteById(id);
        Boolean delete = true;
        return delete;
    }
}
