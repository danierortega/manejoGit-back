/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.service;


import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.repository.QuadbikeRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class QuadbikeService {

    @Autowired
    QuadbikeRepository repository;
    @Autowired
    ICategoryRepository categoryRepository;
    
    public Iterable<Quadbike> get(){

        Iterable<Quadbike> response = repository.getAll();
        return response;
    }

    public Optional<Quadbike> get(Integer id){

        Optional<Quadbike> response = repository.findById(id);
        return response;
    }

    public String create(Quadbike request){
        Optional<Category> cat = categoryRepository.findById(request.getCategory().getId());
        if(!cat.isEmpty()){
            request.setCategory(cat.get());
        }
        if(request.getName()!=null){
            repository.save(request);
            return "Created ...";
            
        }else{
            return "Falta el nombre";
        }
        
    }

    public Quadbike update(Quadbike quadbike){
        Quadbike quadbikeToUpdate = new Quadbike();
        if(repository.existsById(quadbike.getId())){ // si existe
            quadbikeToUpdate = quadbike;
            repository.save(quadbikeToUpdate);
        }
        return quadbikeToUpdate;
    }

    public Boolean delete(Integer id){
        repository.deleteById(id);
        Boolean delete = true;
        return delete;
    }

    

    public List<Object[]> getReport(){
        
       //  List<Quadbike> response = new ArrayList<>();
        //logica de coomo procesar la petición al repositorio
        List<Object[]> result = repository.getReport();
        
        
        return result;
        
    }
}
