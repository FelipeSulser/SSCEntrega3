/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoIndex;
import ejb.LoginEJB;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.ELContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.jpa.ssc.Administrativo;
import model.jpa.ssc.Profesional;

/**
 *
 * @author Esteban
 */

@ManagedBean(name="sesionBean")
@SessionScoped
public class SesionBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private int citasHoy;
    private int totalIntervenciones;
    private String image;
    private String usuario;
    private String dni;
    private Administrativo admin;
    private Profesional pro;
    private boolean isAdmin;
    
   

    

    
 
    
    public int getCitasHoy() {
        return citasHoy;
    }

    public void setCitasHoy(int citasHoy) {
        this.citasHoy = citasHoy;
    }

    public int getTotalIntervenciones() {
        return totalIntervenciones;
    }

    public void setTotalIntervenciones(int totalIntervenciones) {
        this.totalIntervenciones = totalIntervenciones;
    }

    void setAdmin(Administrativo admin) {
        this.admin = admin;
    }

    void setIsAdmin(boolean b) {
        this.isAdmin = b;
        }

    void setProfesional(Profesional pro) {
        this.pro = pro;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Profesional getPro() {
        return pro;
    }

    public void setPro(Profesional pro) {
        this.pro = pro;
    }


    
    
    
    
}