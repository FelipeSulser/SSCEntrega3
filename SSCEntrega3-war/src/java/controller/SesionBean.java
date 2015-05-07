/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoIndex;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.jpa.ssc.Profesional;

/**
 *
 * @author Esteban
 */

@ManagedBean(name="sesionBean")
@SessionScoped
public class SesionBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private DaoIndex dindex = new DaoIndex();
    private int citasHoy;
    private int totalIntervenciones;

    

    public Profesional getUser(){
        //TODO differentiate between admin and user
        //TODO add query 
        setCitasHoy(3);
        setTotalIntervenciones(64);
        
        return dindex.getProf();
    }
    
    
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
    
    
    
    
}