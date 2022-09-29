/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.model.IQuadbikeRepository;
import com.grupo10.app.rents.model.Quadbike;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/api/Client")
public class ClientController {
    
    @Autowired
    IQuadbikeRepository repository;
    
    @GetMapping("/all")
    public Iterable<Quadbike> getQuadbike(){
        Iterable<Quadbike> response = repository.findAll();
        return response;
    }
    
    
    @PostMapping("/save")
    public String createquadbike(@RequestBody Quadbike request){
        
        repository.save(request);
        
        return "created...";
    }
    
    
}
    