package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.entities.Quadbike;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupo10.app.rents.service.QuadbikeService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/api/Quadbike")
public class QuadbikeController {

    @Autowired
    QuadbikeService service;

    @GetMapping("/all")
    public Iterable<Quadbike> get() {
        return service.get();
    }
    
    @GetMapping("/{id}")
    public Optional<Quadbike> get(@PathVariable("id") Integer id) {
        return service.get(id);
    }
    
    @GetMapping("/reports")
    public List<Object[]> getReport() {
        return service.getReport();
    }
    
    /*
    @GetMapping("/reports/{id}")
    public List<Object[]> getReport(@PathVariable("id") Integer id) {
        return service.getReport();
    }
    */

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Quadbike request) {
        service.create(request);
    }
    
    @PutMapping("/update")
    //@ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Quadbike request) {
        service.update(request);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //@ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean delete(@PathVariable("id") Integer id) {
        return service.delete(id);
    }

}
