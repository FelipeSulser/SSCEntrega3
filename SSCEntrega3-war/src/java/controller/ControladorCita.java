/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.InfoCitaEJB;
import exceptions.CrearIntervencionException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import model.jpa.ssc.Cita;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.Intervenciones;
import model.jpa.ssc.Profesional;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import model.jpa.ssc.EstadoCita;

/**
 *
 * @author Álvaro
 */

@Named(value="controladorCita")
@RequestScoped
public class ControladorCita {
    
    @EJB
    private InfoCitaEJB infoCitaEJB;

    
    
    
    //Datos de la cita
    private Date fecha;
    private String comentarios;

    

    public void setId(Long id) {
        this.id = id;
    }
    private String tipo_de_cita;
    private Ciudadano ciudadano;
    private Profesional profesional;
    private List<Intervenciones> intervenciones;
    private EstadoCita estado;
    private String estadoString;

    private boolean addingIntervencion;
    private java.util.Date intervencionDate;
    private Intervenciones newIntervencion = new Intervenciones();

 
    
    //Id obtenido al crear una cita o al pinchar en ver cita
    private Long id;
    
    
    public ControladorCita(){
        
    }
    
    public void init(){
        if(this.id != null){
            fecha = infoCitaEJB.getFecha(id);
            comentarios = infoCitaEJB.getComentarios(id);
            tipo_de_cita = infoCitaEJB.getTipo_de_cita(id);
            ciudadano = infoCitaEJB.getCiudadano(id);
            profesional = infoCitaEJB.getProfesional(id);
            intervenciones = infoCitaEJB.getIntervenciones(id);
            estado = infoCitaEJB.getEstado(id);
        }
                
    }
    
    /**
     * Mejor usar init()
     * @param id de la cita
     * @return info_cita.xhtml con todos los datos cargados
     */
    public String browsePage(Long id){
        if(id == null) return "index.xhtml";
        this.id=id;
        fecha = infoCitaEJB.getFecha(id);
        comentarios = infoCitaEJB.getComentarios(id);
        tipo_de_cita = infoCitaEJB.getTipo_de_cita(id);
        ciudadano = infoCitaEJB.getCiudadano(id);
        profesional = infoCitaEJB.getProfesional(id);
        intervenciones = infoCitaEJB.getIntervenciones(id);
        estado = infoCitaEJB.getEstado(id);
        
        return "info_cita.xhtml";
    }
        
    
    public void initialize(Cita c){
       
    }

    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public String getTipo_de_cita() {
        return tipo_de_cita;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public List<Intervenciones> getIntervenciones() {
        return intervenciones;
    }

    public EstadoCita getEstado(){
        return estado;
    }
    
    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }
    
    public void updateEstado(ValueChangeEvent e){
        UIComponent menu = (UIInput) e.getComponent();
        long idCitaFromView = (Long)menu.getAttributes().get("atributoIdCita");
        switch((String)e.getNewValue()){
            case "citaPlanificada":
                this.estado = EstadoCita.citaPlanificada;
                infoCitaEJB.setEstado(idCitaFromView, EstadoCita.citaPlanificada);
                break;
            case "ausencia":
                System.out.println("Entra aqui");
                this.estado = EstadoCita.ausencia;
                infoCitaEJB.setEstado(idCitaFromView, EstadoCita.ausencia);
                break;
            case "noRealizada":
                this.estado = EstadoCita.noRealizada;
                infoCitaEJB.setEstado(idCitaFromView, EstadoCita.noRealizada);
                break;
            case "planificadaPorOtroProfesional":
                this.estado = EstadoCita.planificadaPorOtroProfesional;
                infoCitaEJB.setEstado(idCitaFromView, EstadoCita.planificadaPorOtroProfesional);
                break;
        }
    }
    
    
    public String getEstadoString() {
        return estadoString;
    }

    public void setEstadoString(String estadoString) {
        this.estadoString = estadoString;
    }
    
    public InfoCitaEJB getInfoCitaEJB() {
        return infoCitaEJB;
    }

    public void setInfoCitaEJB(InfoCitaEJB infoCitaEJB) {
        this.infoCitaEJB = infoCitaEJB;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setTipo_de_cita(String tipo_de_cita) {
        this.tipo_de_cita = tipo_de_cita;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public void setIntervenciones(List<Intervenciones> intervenciones) {
        this.intervenciones = intervenciones;
    }
    
    public boolean isAddingIntervencion() {
        return addingIntervencion;
    }

    public void setAddingIntervencion(boolean addingIntervencion) {
        this.addingIntervencion = addingIntervencion;
    }
    
    public Date getIntervencionDate() {
        return intervencionDate;
    }

    public void setIntervencionDate(Date intervencionDate) {
        this.intervencionDate = intervencionDate;
    }

    public Intervenciones getNewIntervencion() {
        return newIntervencion;
    }

    public void setNewIntervencion(Intervenciones newIntervencion) {
        this.newIntervencion = newIntervencion;
    }
    
    public String persistIntervencion() {
        ciudadano = infoCitaEJB.getCiudadano(id); //En este punto ciudadano es null por algún motivo desconocido
        if(intervencionDate == null){
            FacesContext.getCurrentInstance().addMessage("formulario_add_intervenciones", new FacesMessage("No se ha podido crear la intervencón. Introduzca la fecha por favor."));
            newIntervencion = new Intervenciones();
            addingIntervencion = false;
            return browsePage(id);
        }
        if(newIntervencion.getAnotaciones().isEmpty()){
            FacesContext.getCurrentInstance().addMessage("formulario_add_intervenciones", new FacesMessage("No se ha podido crear la intervención. Introduzca alguna anotación por favor."));
            newIntervencion = new Intervenciones();
            addingIntervencion = false;
            return browsePage(id);
        }
        java.sql.Date dat = new java.sql.Date(intervencionDate.getTime());
        newIntervencion.setFecha(dat);
        if(ciudadano == null){
            FacesContext.getCurrentInstance().addMessage("formulario_add_intervenciones", new FacesMessage("No se ha podido crear la intervencón"));
            newIntervencion = new Intervenciones();
            addingIntervencion = false;
            return browsePage(id);
        }
        Long exp_id = ciudadano.getExpediente_personal().getId();
        try {
            infoCitaEJB.setIntervencion(exp_id, this.id, newIntervencion);
        } catch (CrearIntervencionException ex) {
            FacesContext.getCurrentInstance().addMessage("formulario_add_intervenciones", new FacesMessage("No se ha podido crear la intervencón"));
        }
        
        newIntervencion = new Intervenciones();
        addingIntervencion = false;
        return browsePage(id);
    }
    
}
