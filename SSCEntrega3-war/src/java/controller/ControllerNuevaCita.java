/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.CrearCitaEJB;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import model.jpa.ssc.Cita;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.EstadoCita;
import model.jpa.ssc.Profesional;

/**
 *
 * @author haritz
 */
@Named(value="ctrNuevaCita")
@RequestScoped
public class ControllerNuevaCita implements Serializable {
    
    @EJB
    private CrearCitaEJB crearCitaBean;
    
    

    @ManagedProperty(value = "#{controladorCita}")
    private ControladorCita controladorCita; //Para poder pasarle el id a ver cita.

    
    private String DNICiudadano;
    private Ciudadano ciudadano;
    
    private String DNIProfesional;
    private Profesional profesional;
    
    
    private Date fecha;
    private String tipoCita;
    private String detalleGestion;
        

    
    public String getDNICiudadano() {
        return DNICiudadano;
    }

    public void setDNICiudadano(String DNICiudadano) {
        this.DNICiudadano = DNICiudadano;
    }

    public String getDNIProfesional() {
        return DNIProfesional;
    }

    public void setDNIProfesional(String DNIProfesional) {
        this.DNIProfesional = DNIProfesional;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public String getDetalleGestion() {
        return detalleGestion;
    }

    public void setDetalleGestion(String detalleGestion) {
        this.detalleGestion = detalleGestion;
    }
    
    public CrearCitaEJB getCrearCitaBean() {
        return crearCitaBean;
    }

    public void setCrearCitaBean(CrearCitaEJB crearCitaBean) {
        this.crearCitaBean = crearCitaBean;
    }

    public ControladorCita getControladorCita() {
        return controladorCita;
    }

    public void setControladorCita(ControladorCita controladorCita) {
        this.controladorCita = controladorCita;
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

    
    
    public void persistCita() throws IOException{
        ciudadano = crearCitaBean.getCiudadano(DNICiudadano);
        profesional = crearCitaBean.getProfesional(DNIProfesional);
        
        //COnvierto aquí la fecha a sql.date
        java.sql.Date date = new java.sql.Date(fecha.getTime());

        Cita cita = new Cita();
        //Creo la cita ahora.
        cita.setCiudadano(ciudadano);
        cita.setProfesional(profesional);
        cita.setComentarios(detalleGestion);
        cita.setEstado(EstadoCita.citaPlanificada);
        cita.setFecha(date);
        cita.setTipo_de_cita(tipoCita);
        cita.setIntervenciones(null); //Al crear una cita no puede haber ninguna intervención todavía.
        
        crearCitaBean.setCita(cita);
        controladorCita.browsePage(crearCitaBean.getCitaId(cita));
    }

}