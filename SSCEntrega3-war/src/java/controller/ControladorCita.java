/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCita;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.jpa.ssc.Cita;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.Intervenciones;
import model.jpa.ssc.Profesional;

/**
 *
 * @author Álvaro
 */

@ManagedBean(name="controladorCita")
@RequestScoped
public class ControladorCita {
    
    private Long id;
    private Date fecha;
    private String comentarios;
    private String tipo_de_cita;
    private Ciudadano ciudadano;
    private Profesional profesional;
    private List<Intervenciones> intervenciones;
    DaoCita daoEntities;
    
    public ControladorCita(){
        daoEntities = new DaoCita();
        fecha = daoEntities.getFecha();
        ciudadano = daoEntities.getCiudadano();
        comentarios = daoEntities.getComentarios();
        tipo_de_cita = daoEntities.getTipo_de_cita();
        profesional = daoEntities.getProfesional();
        intervenciones = daoEntities.getIntervenciones();
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

    public DaoCita getDaoEntities() {
        return daoEntities;
    }

    public void setDaoEntities(DaoCita daoEntities) {
        this.daoEntities = daoEntities;
    }
    
    
}
