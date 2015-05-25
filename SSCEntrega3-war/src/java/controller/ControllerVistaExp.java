/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.ExpedienteEJB;
import exceptions.ExpedienteException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;

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
    
    public String browsePage(Long id){
        if(id == null) return "index.xhtml";
        this.id= id;
        expediente = expedienteBean.getExpediente(id);
        
        ciudadano = expedienteBean.getCiudadano(id);
        
        principal = expedienteBean.getPrincipal(id);
        
        secundarias = expedienteBean.getSecundarias(id);
        
        familia = expedienteBean.getFamilia(id);
        
        intervenciones = expedienteBean.getIntervenciones(id);
        return "expediente.xhtml?exp_id"+id;
        
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
    
    
    public String persistFamiliar() {
        
        //Debido a que p:calendar usa util.Date hemos de convertirlo a sql Date

        try{
            if(newFamiliar== null){
                FacesContext.getCurrentInstance().addMessage("form_add_familiar", new FacesMessage("No se ha podido crear el familiar"));
                newFamiliar = new Familiar();
                addingFamiliar = false;
                return browsePage(id);
            }
            if(newFamiliar.getDni() == null){
                 FacesContext.getCurrentInstance().addMessage("form_add_familiar", new FacesMessage("No se ha podido crear el familiar, introduzca dni"));
                newFamiliar = new Familiar();
                addingFamiliar = false;
                return browsePage(id);
                }
            if(newFamiliar.getParentesco() == null || newFamiliar.getParentesco().equals("")){
                 FacesContext.getCurrentInstance().addMessage("form_add_familiar", new FacesMessage("No se ha podido crear el familiar, introduzca parentesco"));
                newFamiliar = new Familiar();
                addingFamiliar = false;
                return browsePage(id);
            }
            if(newFamiliar.getNombre() == null){
                 FacesContext.getCurrentInstance().addMessage("form_add_familiar", new FacesMessage("No se ha podido crear el familiar, introduzca nombre"));
                newFamiliar = new Familiar();
                addingFamiliar = false;
                return browsePage(id);
            }
            if(newFamiliar.getApellido1() == null){
                 FacesContext.getCurrentInstance().addMessage("form_add_familiar", new FacesMessage("No se ha podido crear el familiar, introduzca apellido"));
                newFamiliar = new Familiar();
                addingFamiliar = false;
                return browsePage(id);
            }
            if(familiarDate == null){
                  FacesContext.getCurrentInstance().addMessage("form_add_familiar", new FacesMessage("No se ha podido crear el familiar, introduzca fecha"));
                newFamiliar = new Familiar();
                addingFamiliar = false;
                return browsePage(id);
            }
            java.sql.Date dat = new Date(familiarDate.getTime());
            newFamiliar.setFecha_nacimiento(dat);


            expedienteBean.setFamiliar(id, newFamiliar);

            //as familiar is already persisted, just add it
            newFamiliar = new Familiar();

            addingFamiliar = false;
            //si, añadimos la query string a mano 
        }catch(ExpedienteException e){
            FacesContext ctx = FacesContext.getCurrentInstance();
            String error = "No se ha podido crear el familiar";
            ctx.addMessage("form_add_familiar", new FacesMessage(error));
           
        }
        return browsePage(id);
    }
     public String persistVivienda() {
         try{
             
             if(newVivienda == null){
               FacesContext.getCurrentInstance().addMessage("form_add_familiar", new FacesMessage("No se ha podido crear la vivienda"));
               newVivienda = new Vivienda();
               addingVivienda = false;
               return browsePage(id);
             }
             if(newVivienda.getCalle() == null) {
                 FacesContext.getCurrentInstance().addMessage("form_add_familiar", new FacesMessage("No se ha podido crear la vivienda, introduzca la direccion"));
               newVivienda = new Vivienda();
               addingVivienda = false;
               return browsePage(id);
             }
             if(newVivienda.getCodigoPostal() == null || newVivienda.getCodigoPostal().equals("")){
                 FacesContext.getCurrentInstance().addMessage("form_add_familiar", new FacesMessage("No se ha podido crear la vivienda, introduzca CP"));
               newVivienda = new Vivienda();
               addingVivienda = false;
               return browsePage(id);
             }
             if(newVivienda.getMunicipio() == null || newVivienda.getMunicipio().equals("")){
                  FacesContext.getCurrentInstance().addMessage("form_add_familiar", new FacesMessage("No se ha podido crear la vivienda, introduzca municipio"));
               newVivienda = new Vivienda();
               addingVivienda = false;
               return browsePage(id);
             }
             expedienteBean.setVivienda(id, newVivienda);
             newVivienda = new Vivienda();
             addingVivienda = false;
         }catch(ExpedienteException e){
              FacesContext ctx = FacesContext.getCurrentInstance();
            String error = "No se ha podido crear el familiar";
            ctx.addMessage("formulario_vivienda", new FacesMessage(error));
         }
        return browsePage(id);
        //FacesContext.getCurrentInstance().getExternalContext().redirect("expediente.xhtml?exp_id="+id);
    }

    public java.util.Date getFamiliarDate() {
        return familiarDate;
    }

    public void setFamiliarDate(java.util.Date familiarDate) {
        this.familiarDate = familiarDate;
    }
    
}