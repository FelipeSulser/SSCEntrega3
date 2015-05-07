/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCita;
import dao.DaoNuevaCita;
import java.io.Serializable;
import java.util.Date;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author haritz
 */
@ManagedBean(name="ctrNuevaCita")
@RequestScoped //Not sure about this
public class ControllerNuevaCita implements Serializable {
    
    private String DNICiudadano;
    private String DNIProfesional;
    private Date fecha;
    private int numIntervencion;
    private String tipoCita;
    private String detalleGestion;
    private DaoNuevaCita dao = new DaoNuevaCita();
    

    public DaoNuevaCita getDao() {
        return dao;
    }

    public void setDao(DaoNuevaCita dao) {
        this.dao = dao;
    }
    
    public String crearCita(){
        dao.setTipo_de_cita(tipoCita);
        dao.setDetalleGestion(detalleGestion);
        dao.setFecha(fecha);
        return "info_cita.xhtml";
    }
    
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
}