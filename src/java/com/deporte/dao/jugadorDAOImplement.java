/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deporte.dao;

import com.deporte.domain.Jugador;
import com.deporte.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author labso11
 */
public class jugadorDAOImplement implements jugadorDAO{
    //establecer la sesion con la bd.
    Session session;

    @Override
    public void crearRegistro(Jugador jugador) {
        try{
            session =HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(jugador);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e){
            System.err.println("Error al crear el registro;"+e.getMessage());
        }        
    }

    @Override
    public void actualizarRegistro(Jugador jugador) {
        try{
            session =HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(jugador);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e){
            System.err.println("Error al actualizar el registro;"+e.getMessage());
        }      
    }
    @Override
    public void eliminarRegistro(Jugador jugador) {
        try{
            session =HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //session.createQuery("Delete from jugador where idJugador=" + idJugador).executeUpdate();
            session.delete(jugador);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e){
            System.err.println("Error al eliminar el registro;"+e.getMessage());
        } 
    }  

    @Override
    public List<Jugador> obtenerRegistros() {
         try{             
            session =HibernateUtil.getSessionFactory().openSession();        
            return session.createQuery("FROM Jugador").list();
        }catch(HibernateException e){
            System.err.println("Error al optener el registro;"+e.getMessage());
            return null;
        }   
    }

    @Override
    public Jugador obtenerRegistro(int idJugador) {
          try{             
            session =HibernateUtil.getSessionFactory().openSession();
            Jugador jugador = (Jugador) session.createQuery("select * from jugador where idJugador ="+idJugador).uniqueResult();
            session.close();
            return jugador;
        }catch(HibernateException e){
            System.err.println("Error al optener el registro;"+e.getMessage());
            return null;
        } 
    }
    
}
