
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import com.grupo10.app.rents.entities.Quadbike;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    @Autowired
    ICategoryRepository repository;


    public Iterable<Category> get() {
        Iterable<Category> response = repository.findAll();
        return response;
    }

    public String create(Category request) {
        if (request.getName() != null) {
            repository.save(request);
            return "created...";
        } else {
            return "falta nombre";
        }

    }

    public Category update(Category category) {
        if(category.getId()!=null){
            Optional<Category> e= repository.findById(category.getId());
            if(!e.isEmpty()){
                if(category.getName()!=null){
                    e.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    e.get().setDescription(category.getDescription());
                }
                repository.save(e.get());
                return e.get();
            }else{
                return category;
            }
        }else{
            return category;
        }
    }

    public Boolean delete(Integer id) {
        repository.deleteById(id);
        Boolean delete = true;
        return delete;
    }
}
