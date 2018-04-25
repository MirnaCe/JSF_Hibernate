/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deporte.dao;

import com.deporte.domain.Jugador;
import java.util.List;

/**
 *
 * @author labso11
 */
public interface jugadorDAO {
    public List<Jugador> obtenerRegistros();
    
    public void crearRegistro(Jugador jugador);
    
    public void actualizarRegistro(Jugador jugador);  
    
    public void eliminarRegistro(Jugador jugador);    
    
    public Jugador obtenerRegistro(int idJugador);
    
}
