/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.interfaces.IQuadbikeRepository;

import com.grupo10.app.rents.entities.Message;

import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.interfaces.IClientRepository;
import com.grupo10.app.rents.interfaces.IMessageRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class MessageService {

    @Autowired
    IMessageRepository messageRepository;

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    IQuadbikeRepository quadbikeRepository;

    public Iterable<Message> get(){

        Iterable<Message> response = messageRepository.findAll();

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
           messageRepository.save(request);
            return "Created ...";
            
        }else{
            return "Falta el nombre";
        }
        
    }
}
