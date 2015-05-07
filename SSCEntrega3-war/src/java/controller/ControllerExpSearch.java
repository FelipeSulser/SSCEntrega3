/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoExpedientes;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.jpa.ssc.Expediente;

/**
 *
 * @author Esteban
 */

@ManagedBean(name="ctrExps")
@RequestScoped
public class ControllerExpSearch implements Serializable{
    private static final long serialVersionUID = 1L;
    private DaoExpedientes EXP_INTERFACE = new DaoExpedientes();
    private boolean searchDone = false;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int exp_id;
    private String filtrosDeBusqueda;

    
    public String getNameFromId(Long id){
        return EXP_INTERFACE.getOwnerFromID().get(id);
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
        //TODO add query transmission to DaoExpedientes
        filtrosDeBusqueda = "Se aplicaron los siguientes filtros: "+ nombre + " - " + apellido1 + " - " + apellido2 + " - " + exp_id;
        this.setSearchDone(true);
    }
    
    public List<Expediente> getConsultarExpedientes() {
        return EXP_INTERFACE.getExpedientes();
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

    public int getExp_id() {
        return exp_id;
    }

    public void setExp_id(int exp_id) {
        this.exp_id = exp_id;
    }
    
}