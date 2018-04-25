
package com.deporte.services;

import com.deporte.domain.Jugador;
import java.util.List;


public interface jugadorService {
    
    public void crearRegistro(Jugador jugador);
    
    public List<Jugador> obtenerRegistros();
    
    public void actualizarRegistro(Jugador jugador);  
    
    public void eliminarRegistro(Jugador jugador);    
    
    public Jugador obtenerRegistro(int idJugador);    

}
