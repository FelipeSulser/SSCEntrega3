/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCita;
import dao.DaoNuevaCita;
import ejb.CrearCitaEJB;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.jpa.ssc.Cita;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.EstadoCita;
import model.jpa.ssc.Profesional;

/**
 *
 * @author haritz
 */
@ManagedBean(name="ctrNuevaCita")
@RequestScoped //Not sure about this
public class ControllerNuevaCita implements Serializable {
    
    @EJB
    private CrearCitaEJB crearCitaBean;
    
    private String DNICiudadano;
    private Ciudadano ciudadano;
    
    private String DNIProfesional;
    private Profesional profesional;
    
    
    private Date fecha;
    private int numIntervencion; /// <------------- DUDA
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

    public int getNumIntervencion() {
        return numIntervencion;
    }

    public void setNumIntervencion(int numIntervencion) {
        this.numIntervencion = numIntervencion;
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
    
    
    
    public String persistCita() throws IOException{
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
        
        return "info_cita.xhtml";
    }

}