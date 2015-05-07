/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.jpa.ssc.Cita;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.Intervenciones;
import model.jpa.ssc.Profesional;

/**
 *
 * @author Álvaro
 */
public class DaoCita {
    
    private Long id;
    private Date fecha;
    private Cita cita;
    private String comentarios;
    private String tipo_de_cita;
    private Ciudadano ciudadano;
    private Profesional profesional;
    private List<Intervenciones> intervenciones;
    
    
    public DaoCita(){
        
        ciudadano = new Ciudadano();
        ciudadano.setNombre("Jeff");
        ciudadano.setApellido1("Costello");
        ciudadano.setApellido2("Singer");
        ciudadano.setDni("51111631H");
        ciudadano.setNacionalidad("Estadounidense");
        ciudadano.setFecha_nacimiento(new Date(Calendar.getInstance().getTimeInMillis()));
        
        profesional = new Profesional();
        profesional.setNombre("Jep");
        profesional.setApellido1("Gambardella");
        profesional.setApellido2("Sorrentino");
        profesional.setDni("52223631H");
        
        Intervenciones i1 = new Intervenciones();
        i1.setAnotaciones("Todo ha ido bien");
        i1.setFecha(new Date(Calendar.getInstance().getTimeInMillis()));
        intervenciones = new ArrayList();
        intervenciones.add(i1);
        
        cita = new Cita();
        cita.setId(new Long(1332));
        cita.setFecha(new Date(Calendar.getInstance().getTimeInMillis()));
        cita.setCiudadano(ciudadano);
        cita.setComentarios("Primera cita");
        cita.setProfesional(profesional);
        cita.setIntervenciones(intervenciones);
        cita.setTipo_de_cita("Asistencia a mayores de edad");
        
        fecha=cita.getFecha();
        tipo_de_cita=cita.getTipo_de_cita();
        comentarios=cita.getComentarios();
        
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

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
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
    
    public List<Cita> getAllCitas(){
       List<Cita> lista = new ArrayList();
       lista.add(cita);
       return lista;
    }
    
}
