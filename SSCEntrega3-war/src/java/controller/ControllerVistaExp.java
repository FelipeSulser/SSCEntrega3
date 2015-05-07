/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoExpedienteView;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.Expediente;
import model.jpa.ssc.Familiar;
import model.jpa.ssc.Intervenciones;
import model.jpa.ssc.Vivienda;

/**
 *
 * @author felipesulser
 */
@ManagedBean(name="expedienteView")
@RequestScoped
public class ControllerVistaExp {
    
   
    private Expediente expediente;
    private Ciudadano ciudadano;
    private List<Intervenciones> intervenciones;
    private List<Familiar> familia;
    private Vivienda principal;
    private List<Vivienda> secundarias;
    DaoExpedienteView daoEntities;
    
    private boolean addingFamiliar;
    
    private boolean addingVivienda;
    private boolean addingIntervencion;
    
    private Familiar newFamiliar = new Familiar();
    private java.util.Date familiarDate ;
    private java.util.Date intervencionDate;
    private java.util.Date viviendaDate;
    private Intervenciones newIntervencion = new Intervenciones();
    
    private Vivienda newVivienda = new Vivienda();
    
    
    
    private Long id;
    
    
    public ControllerVistaExp() {
       
       daoEntities = new DaoExpedienteView(id);
       expediente = daoEntities.getExpediente();
       ciudadano = daoEntities.getCiudadano();
       secundarias = daoEntities.getSecundarias();
       principal = daoEntities.getPrincipal();
        familia = daoEntities.getFamilia();
        intervenciones = daoEntities.getIntervenciones();
       
        
    }
    
  
    
    public void initialize(Expediente e){
       
        
    }
    
    
    public void addFamiliar() throws IOException{
        addingFamiliar = true;
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("expediente.xhtml");
        
    }
  
    
    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public List<Intervenciones> getIntervenciones() {
        return intervenciones;
    }

    public void setIntervenciones(List<Intervenciones> intervencion) {
       this.intervenciones = intervencion;
    }
   

    public List<Familiar> getFamilia() {
        return familia;
    }

    public void setFamilia(List<Familiar> familia) {
       this.familia = familia;
    }

    public Vivienda getPrincipal() {
        return principal;
    }

    public void setPrincipal(Vivienda principal) {
       this.principal = principal;
    }

    public List<Vivienda> getSecundarias() {
        return secundarias;
    }

    public void setSecundarias(List<Vivienda> secundarias) {
       this.secundarias = secundarias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DaoExpedienteView getDaoEntities() {
        return daoEntities;
    }

    public void setDaoEntities(DaoExpedienteView daoEntities) {
        this.daoEntities = daoEntities;
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
        
        //AQUI DEBERIA COMUNICARME CON EL EJB PARA AÑADIR EL FAMILIAR EN DB
        
        
        addingFamiliar = false;
        FacesContext.getCurrentInstance().getExternalContext().redirect("expediente.xhtml");
    }
     public void persistVivienda() throws IOException{
        
        //AQUI DEBERIA COMUNICARME CON EL EJB PARA AÑADIR EL FAMILIAR EN DB
        
        
        addingVivienda = false;
        FacesContext.getCurrentInstance().getExternalContext().redirect("expediente.xhtml");
    }
     public String persistIntervencion() throws IOException{
        
        //AQUI DEBERIA COMUNICARME CON EL EJB PARA AÑADIR EL FAMILIAR EN DB
        
        
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

    public java.util.Date getViviendaDate() {
        return viviendaDate;
    }

    public void setViviendaDate(java.util.Date viviendaDate) {
        this.viviendaDate = viviendaDate;
    }
     
     
     
    
    
    
}