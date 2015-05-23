/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.InfoCitaEJB;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import model.jpa.ssc.Cita;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.Intervenciones;
import model.jpa.ssc.Profesional;

import javax.enterprise.context.RequestScoped;
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

    


    
    //Id obtenido al crear una cita o al pinchar en ver cita
    private Long id;
    
    
    public ControladorCita(){
        
    }
    
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
    
    public void updateEstado(){
        System.out.println("hola" + estadoString + " " + id);
        switch(estadoString){
            case "citaPlanificada":
                this.estado = EstadoCita.citaPlanificada;
                infoCitaEJB.setEstado(id, EstadoCita.citaPlanificada);
            case "ausencia":
                this.estado = EstadoCita.ausencia;
                infoCitaEJB.setEstado(id, EstadoCita.ausencia);
            case "noRealizada":
                this.estado = EstadoCita.noRealizada;
                infoCitaEJB.setEstado(id, EstadoCita.noRealizada);
            case "planificadaPorOtroProfesional":
                this.estado = EstadoCita.planificadaPorOtroProfesional;
                infoCitaEJB.setEstado(id, EstadoCita.planificadaPorOtroProfesional);

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
    
}
