/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.ExpedienteEJB;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import javax.faces.context.FacesContext;


import javax.inject.Inject;
import javax.inject.Named;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.Expediente;
import model.jpa.ssc.Familiar;
import model.jpa.ssc.Intervenciones;
import model.jpa.ssc.Vivienda;


/**
 *
 * @author felipesulser
 */
@Named(value="expedienteView")
@RequestScoped
public class ControllerVistaExp implements Serializable{
    //Injected
    @Inject
    private ExpedienteEJB expedienteBean;
    
    
   /******************** Datos del expediente *************************/
    
    
    private Expediente expediente;
    private Ciudadano ciudadano;
    private List<Intervenciones> intervenciones;
    private List<Familiar> familia;
    private Vivienda principal;
    private List<Vivienda> secundarias;
   
    
   /********************************************************************/
    
    
    /****************Logica de introduccion de datos******************/
    private boolean addingFamiliar;
    private boolean addingVivienda;
    
    
    /* FOR THE NEW FAMILIAR */
    private Familiar newFamiliar = new Familiar();
    private java.util.Date familiarDate ;
    
   
    
    
    /* FOR THE NEW VIVIENDA */
    private Vivienda newVivienda = new Vivienda();
    
    /********************************************************************/
    
    /**
     * Este valor es obtenido al cambiar de vista de expedientes a expediente.xhtml
     * 
     */
    private Long id;
    
    
    public ControllerVistaExp() {
   
    }
    
    
    
    
    public void init(){
        
        
         expediente = expedienteBean.getExpediente(id);
        
        ciudadano = expedienteBean.getCiudadano(id);
        
        principal = expedienteBean.getPrincipal(id);
        
        secundarias = expedienteBean.getSecundarias(id);
        
        familia = expedienteBean.getFamilia(id);
        
        intervenciones = expedienteBean.getIntervenciones(id);
        
        
    }
    public void addFamiliar() throws IOException{
        addingFamiliar = true;
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("expediente.xhtml");
        
    }
    
  
    
    public Expediente getExpediente() {
        return expediente;
    }

   

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

   

    public List<Intervenciones> getIntervenciones() {
        return intervenciones;
    }

   
   

    public List<Familiar> getFamilia() {
        return familia;
    }

    

    public Vivienda getPrincipal() {
        return principal;
    }

   
    public List<Vivienda> getSecundarias() {
        return secundarias;
    }

   
    public void setId(Long id) {
         this.id = id;
    }
    public Long getId() {
        return id;
    }
    public boolean isAddingFamiliar() {
        return addingFamiliar;
    }

    public void setAddingFamiliar(boolean addingFamiliar) {
        this.addingFamiliar = addingFamiliar;
    }

    public boolean isAddingVivienda() {
        return addingVivienda;
    }

    public void setAddingVivienda(boolean addingVivienda) {
        this.addingVivienda = addingVivienda;
    }

    public Familiar getNewFamiliar() {
        return newFamiliar;
    }

    public void setNewFamiliar(Familiar newFamiliar) {
        this.newFamiliar = newFamiliar;
    }

    public Vivienda getNewVivienda() {
        return newVivienda;
    }

    public void setNewVivienda(Vivienda newVivienda) {
        this.newVivienda = newVivienda;
    }
    
    
    public void persistFamiliar() throws IOException{
        
        //Debido a que p:calendar usa util.Date hemos de convertirlo a sql Date

        
        java.sql.Date dat = new Date(familiarDate.getTime());
        newFamiliar.setFecha_nacimiento(dat);
        expedienteBean.setFamiliar(id, newFamiliar);
        
        //as familiar is already persisted, just add it
        newFamiliar = new Familiar();
        
        addingFamiliar = false;
        FacesContext.getCurrentInstance().getExternalContext().redirect("expediente.xhtml");
    }
     public void persistVivienda() throws IOException{
         
        expedienteBean.setVivienda(id, newVivienda);
        
        newVivienda = new Vivienda();
        addingVivienda = false;
        FacesContext.getCurrentInstance().getExternalContext().redirect("expediente.xhtml");
    }

    public java.util.Date getFamiliarDate() {
        return familiarDate;
    }

    public void setFamiliarDate(java.util.Date familiarDate) {
        this.familiarDate = familiarDate;
    }
    
}