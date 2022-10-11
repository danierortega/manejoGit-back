package com.grupo10.app.rents.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.grupo10.app.rents.entities.Admin;

public interface IAdminRepository extends CrudRepository <Admin, Integer> {
    
}
