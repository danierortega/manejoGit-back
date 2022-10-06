
package com.grupo10.app.rents.interfaces;

import com.grupo10.app.rents.entities.Score;
import org.springframework.data.repository.CrudRepository;

public interface IScoreRepository extends CrudRepository <Score, Integer>{
    
}
