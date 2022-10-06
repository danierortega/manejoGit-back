package com.grupo10.app.rents.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Andres
 */
@Entity
@Table(name="tb_reservation")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer idReservation;
    @Column
    private java.util.Date startDate;
    @Column
    private java.util.Date devolutionDate;
    @Column
    private String status="created";
 
    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JsonIgnoreProperties({"reservations"})
    @JoinColumn(name="quadbike_id")
    private Quadbike quadbike;
    
    @ManyToOne
    @JsonIgnoreProperties({"reservations","messages"})
    @JoinColumn(name="client_id")
    private Client client; 

    @OneToOne(cascade= {CascadeType.REMOVE},mappedBy="reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;
}
