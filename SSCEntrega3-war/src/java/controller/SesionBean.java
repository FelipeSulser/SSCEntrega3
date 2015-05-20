/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
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
    private long userId;
    

    public Profesional getUser(){
        //TODO differentiate between admin and user
        //TODO add query 
        setCitasHoy(3);
        setTotalIntervenciones(64);
        Profesional p = new Profesional();
        p.setApellido1("Suárez");
        p.setApellido2("Fernández");
        p.setNombre("Juan");
        p.setId(2L);
        p.setUsuario("usuarioFake1234");
        p.setDni("11223344E");
        return p;
    }
    public void setUserId(long id){
        userId = id;
    }
    public long getUserId(){
        return 2; //TO DOOOOOOOOOOOOO
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