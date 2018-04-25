/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deporte.services;

import com.deporte.dao.jugadorDAO;
import com.deporte.dao.jugadorDAOImplement;
import com.deporte.domain.Jugador;
import java.util.List;

/**
 *
 * @author labso11
 */
public class JugadorServiceImpl implements jugadorService{

    private jugadorDAO jugadordao =new jugadorDAOImplement();
    
    @Override
    public void crearRegistro(Jugador jugador) {
        jugadordao.crearRegistro(jugador);
    }

    @Override
    public List<Jugador> obtenerRegistros() {
        return jugadordao.obtenerRegistros();
    }

    @Override
    public void actualizarRegistro(Jugador jugador) {
        jugadordao.actualizarRegistro(jugador);
    }

    @Override
    public void eliminarRegistro(Jugador jugador) {
        jugadordao.eliminarRegistro(jugador);
    }

    @Override
    public Jugador obtenerRegistro(int idJugador) {
       return jugadordao.obtenerRegistro(idJugador);
    }
}
