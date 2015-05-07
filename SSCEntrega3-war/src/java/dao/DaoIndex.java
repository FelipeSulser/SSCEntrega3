/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.LinkedList;
import java.util.List;
import model.jpa.ssc.Administrativo;
import model.jpa.ssc.Profesional;

/**
 *
 * @author Esteban
 */
public class DaoIndex {
    
    //En la siguiente entrega hacer lógica de negocio para saber si era profesional o admin el 
    //usuario que se ha logueado
    private Profesional p;
    private Administrativo a;
    

    public Profesional getProf() {
        return p;
    }
    
    public DaoIndex(){
        p = new Profesional();
        p.setApellido1("Pascales");
        p.setApellido2("del Valle");
        p.setNombre("Lorenzo");
        p.setDni("77188676D");
        p.setUsuario("Lorenzo94");
        p.setImage("profile.png");
    }
}