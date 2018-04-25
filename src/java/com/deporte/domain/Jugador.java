
package com.deporte.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author labso11
 */
@Entity
@Table(name = "jugador")
public class Jugador implements Serializable{

    @Id    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idJugador;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    public Jugador() {
        
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }   
 

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
