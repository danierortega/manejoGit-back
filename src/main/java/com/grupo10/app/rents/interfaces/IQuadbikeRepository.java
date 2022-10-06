
package com.grupo10.app.rents.interfaces;

import com.grupo10.app.rents.entities.Quadbike;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface IQuadbikeRepository extends CrudRepository<Quadbike, Integer> {
 
    @Query("SELECT c.year, COUNT(c.year) from Quadbike AS c group by c.year order by COUNT(c.year) DESC")
    public List<Object[]> countTotalQuadbikeByYear();
}
