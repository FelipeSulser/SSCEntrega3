/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCita;
import ejb.InfoCitaEJB;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.jpa.ssc.Cita;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.Intervenciones;
import model.jpa.ssc.Profesional;
import javax.ejb.EJB;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Álvaro
 */

@ManagedBean(name="controladorCita")
@RequestScoped
public class ControladorCita {
    
    @Inject
    private InfoCitaEJB infoCitaBean;
    
    
    //Datos de la cita
    private Date fecha;
    private String comentarios;
    private String tipo_de_cita;
    private Ciudadano ciudadano;
    private Profesional profesional;
    private List<Intervenciones> intervenciones;
    
    //Id obtenido al crear una cita o al pinchar en ver cita
    private Long id;
    
    
    public ControladorCita(){
        
    }
    
    public String browsePage(Long id){
        
        this.id=id;
        fecha = infoCitaBean.getFecha(id);
        comentarios = infoCitaBean.getComentarios(id);
        tipo_de_cita = infoCitaBean.getTipo_de_cita(id);
        ciudadano = infoCitaBean.getCiudadano(id);
        profesional = infoCitaBean.getProfesional(id);
        intervenciones = infoCitaBean.getIntervenciones(id);
        
        return "info_cita.xhtml";
    }
        
    
    public void initialize(Cita c){
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getTipo_de_cita() {
        return tipo_de_cita;
    }

    public void setTipo_de_cita(String tipo_de_cita) {
        this.tipo_de_cita = tipo_de_cita;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public List<Intervenciones> getIntervenciones() {
        return intervenciones;
    }

    public void setIntervenciones(List<Intervenciones> intervenciones) {
        this.intervenciones = intervenciones;
    }

    
    
}
