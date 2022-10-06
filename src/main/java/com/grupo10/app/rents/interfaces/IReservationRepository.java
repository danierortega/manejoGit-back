
package com.grupo10.app.rents.interfaces;

import com.grupo10.app.rents.entities.Reservation;
import org.springframework.data.repository.CrudRepository;


public interface IReservationRepository extends CrudRepository<Reservation, Integer> {
    
}
