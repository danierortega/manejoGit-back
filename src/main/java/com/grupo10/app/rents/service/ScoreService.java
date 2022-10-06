/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.entities.Score;
import com.grupo10.app.rents.interfaces.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.grupo10.app.rents.interfaces.IScoreRepository;

/**
 *
 * @author user
 */
public class ScoreService {
    @Autowired
    IScoreRepository repository;
    @Autowired
    IReservationRepository reservationRepository;

    public Iterable<Score> get(){
        Iterable<Score> response = repository.findAll();

        return response;
    }

    public String create(Score request){
        if(request.getMessageText()!=null){
            repository.save(request);
            return "Created ...";
            
        }else{
            return "Falta el nombre";
        }
    }
}
