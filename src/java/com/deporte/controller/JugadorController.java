
package com.deporte.controller;

import com.deporte.domain.Jugador;
import com.deporte.services.jugadorService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.deporte.services.JugadorServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

@ViewScoped
//@Named(value = "jugadorController")
@ManagedBean(name = "jugadorController")
public class JugadorController implements Serializable{
    private List<Jugador>  ListaRegistro;
    
    private Jugador jugador;

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    private jugadorService jugadorservice;
    
    private Jugador jugadorseleccionado;

    public void setJugadorservice(jugadorService jugadorservice) {
        this.jugadorservice = jugadorservice;
    }

    public void setJugadorseleccionado(Jugador jugadorseleccionado) {
        this.jugadorseleccionado = jugadorseleccionado;
    }

    public jugadorService getJugadorservice() {
        return jugadorservice;
    }

    public Jugador getJugadorseleccionado() {
        return jugadorseleccionado;
    }
    
    //inicializar objetos
    @PostConstruct
    public void init(){
        this.jugadorservice= new JugadorServiceImpl();
        inicializarListaJugador();
    }
    private void inicializarListaJugador(){
        ListaRegistro=new ArrayList<>();
        ListaRegistro=jugadorservice.obtenerRegistros();
    }

    public List<Jugador> getListaRegistro() {
        return ListaRegistro;
    }

    public void setListaRegistro(List<Jugador> ListaRegistro) {
        this.ListaRegistro = ListaRegistro;
    }
    
    public void crearRegistro(Jugador jugador){
        jugadorservice.crearRegistro(jugador);
    }
    
    public void eliminarRegistro(Jugador jugador){
        jugadorservice.eliminarRegistro(jugador);
        inicializarListaJugador();         
    }
      
   /* public void onRowInsert(InsertEvent event){
        FacesMessage mensaje =new FacesMessage("Jugador nuevo", ((Jugador) event.getObject()).getIdJugador().toString());
        FacesContext .getCurrentInstance().addMessage(null, mensaje);
    }*/
    public void onRowSelect(SelectEvent event){
        FacesMessage mensaje =new FacesMessage("Jugador Seleccionado", ((Jugador) event.getObject()).getIdJugador().toString());
        FacesContext .getCurrentInstance().addMessage(null, mensaje);
    }
    public void onRowEdit(RowEditEvent event){
        jugadorservice.actualizarRegistro(jugadorseleccionado);
        //Jugador jugador =(Jigador)event.getObjet();
        FacesMessage mensaje =new FacesMessage("Jugador Actualizado", ((Jugador) event.getObject()).getIdJugador().toString());
        FacesContext .getCurrentInstance().addMessage(null, mensaje);
    }
    public void onRowCancel(RowEditEvent event){
         FacesMessage mensaje =new FacesMessage("Jugador Cancelado", ((Jugador) event.getObject()).getIdJugador().toString());
        FacesContext .getCurrentInstance().addMessage(null, mensaje);
    }
}
