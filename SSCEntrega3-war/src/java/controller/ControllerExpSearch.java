/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoExpedientes;
import ejb.Buscador_ExpEJB;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;


import javax.inject.Named;
import model.jpa.ssc.Ciudadano;

import model.jpa.ssc.Expediente;

/**
 *
 * @author Esteban
 */

@Named(value="ctrExps")
@ViewScoped
public class ControllerExpSearch implements Serializable{
    private static final long serialVersionUID = 1L;
    @EJB
    private Buscador_ExpEJB EXP_INTERFACE;
    private boolean searchDone = false;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private long exp_id;
    private String filtrosDeBusqueda;
    private Map<Long,Ciudadano> ciudadanos;
    
    public String getNameFromId(Long id){
        if(id == null) return null;
        Ciudadano c = ciudadanos.get(id);
      return c.getNombre() + " "+c.getApellido1()+" "+c.getApellido2();
        //return EXP_INTERFACE.getOwnerFromID().get(id);
    }
    
    public String getFiltrosDeBusqueda() {
        return filtrosDeBusqueda;
    }

    public void setFiltrosDeBusqueda(String out) {
        this.filtrosDeBusqueda = out;
    }

    public boolean isSearchDone() {
        return searchDone;
    }

    public void setSearchDone(boolean searchDone) {
        this.searchDone = searchDone;
    }

    public void performSearch(){
     
        filtrosDeBusqueda = "Se aplicaron los siguientes filtros: "+ nombre + " - " + apellido1 + " - " + apellido2 + " - " + exp_id;
        this.setSearchDone(true);
    }
    
    public List<Expediente> getConsultarExpedientes() {
        ciudadanos = EXP_INTERFACE.getCiudadanos(exp_id,apellido1,apellido2,nombre);
        if(ciudadanos.isEmpty()) return null;
        return EXP_INTERFACE.getExpedientes(exp_id, apellido1, apellido2, nombre);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public long getExp_id() {
        return exp_id;
    }

    public void setExp_id(long exp_id) {
        this.exp_id = exp_id;
    }
    
}