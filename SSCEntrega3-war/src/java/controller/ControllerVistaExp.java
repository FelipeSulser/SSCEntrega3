/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoExpedienteView;
import ejb.ExpedienteEJB;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
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
public class ControllerVistaExp {
    //Injected
    @EJB
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
    private boolean addingIntervencion;
    
    
    /* FOR THE NEW FAMILIAR */
    private Familiar newFamiliar = new Familiar();
    private java.util.Date familiarDate ;
    
   
    /* FOR THE NEW INTERVENTION */
    private Intervenciones newIntervencion = new Intervenciones();
    private Long newInterCitaId;
    private java.util.Date intervencionDate;
    
    
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
    
    
    
    
    public String browsePage(Long id){
        
        this.id = id;
         expediente = expedienteBean.getExpediente(id);
        
        ciudadano = expedienteBean.getCiudadano(id);
        
        principal = expedienteBean.getPrincipal(id);
        
        secundarias = expedienteBean.getSecundarias(id);
        
        familia = expedienteBean.getFamilia(id);
        
        intervenciones = expedienteBean.getIntervenciones(id);
        
        return "expediente.xhtml";
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

    public boolean isAddingIntervencion() {
        return addingIntervencion;
    }

    public void setAddingIntervencion(boolean addingIntervencion) {
        this.addingIntervencion = addingIntervencion;
    }

    public Familiar getNewFamiliar() {
        return newFamiliar;
    }

    public void setNewFamiliar(Familiar newFamiliar) {
        this.newFamiliar = newFamiliar;
    }

    public Intervenciones getNewIntervencion() {
        return newIntervencion;
    }

    public void setNewIntervencion(Intervenciones newIntervencion) {
        this.newIntervencion = newIntervencion;
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
     public String persistIntervencion() throws IOException{
        
         
         
        //AQUI DEBERIA COMUNICARME CON EL EJB PARA AÑADIR EL FAMILIAR EN DB
         
         //NOTA: he de usar el campo de newInterCitaId y hallar la cita, y asociarla a la intervencion
        java.sql.Date dat = new Date(intervencionDate.getTime());
        newIntervencion.setFecha(dat);
        
        expedienteBean.setIntervencion(id, newInterCitaId, newIntervencion);
        
        newIntervencion = new Intervenciones();
        addingIntervencion = false;
        FacesContext.getCurrentInstance().getExternalContext().redirect("expediente.xhtml");
        return "Intervencion added";
    }

    public java.util.Date getFamiliarDate() {
        return familiarDate;
    }

    public void setFamiliarDate(java.util.Date familiarDate) {
        this.familiarDate = familiarDate;
    }

    public java.util.Date getIntervencionDate() {
        return intervencionDate;
    }

    public void setIntervencionDate(java.util.Date intervencionDate) {
        this.intervencionDate = intervencionDate;
    }

    public Long getNewInterCitaId() {
        return newInterCitaId;
    }

    public void setNewInterCitaId(Long newInterCitaId) {
        this.newInterCitaId = newInterCitaId;
    }
     
     
     
    
    
    
}