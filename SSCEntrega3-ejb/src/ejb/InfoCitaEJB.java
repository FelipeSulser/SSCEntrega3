/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.jpa.ssc.Cita;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.EstadoCita;
import model.jpa.ssc.Intervenciones;
import model.jpa.ssc.Profesional;

/**
 *
 * @author Álvaro
 */
@Stateless
@LocalBean
public class InfoCitaEJB {

    @PersistenceContext(unitName="SSCPU")
    private EntityManager em;
    
    public Date getFecha(Long id){        
        try{
            Cita cita = em.find(Cita.class, id);
            return cita.getFecha();
        }catch(RuntimeException e){
            return null;
        }
    }
    
    public String getComentarios(Long id){        
        try{
            Cita cita = em.find(Cita.class, id);
            return cita.getComentarios();
        }catch(RuntimeException e){
            return null;
        }
    }
    
    public String getTipo_de_cita(Long id){
        try{
            Cita cita = em.find(Cita.class, id);
            return cita.getTipo_de_cita();
        }catch(RuntimeException e){
            return null;
        }
    }
    
    public Ciudadano getCiudadano(Long id){
        try{
            Cita cita = em.find(Cita.class, id);
            return cita.getCiudadano();
        }catch(RuntimeException e){
            return null;
        }
    }
    
    public Profesional getProfesional(Long id){
        try{
            Cita cita = em.find(Cita.class, id);
            return cita.getProfesional();
        }catch(RuntimeException e){
            return null;
        }
    }
    
    public List<Intervenciones> getIntervenciones(Long id){
        try{
            Cita cita = em.find(Cita.class, id);
            return cita.getIntervenciones();
        }catch(RuntimeException e){
            return null;
        }
    }
    
    
    public EstadoCita getEstado(Long id){
        try{
            Cita cita = em.find(Cita.class, id);
            return cita.getEstado();
        }catch(RuntimeException e){
            return null;
        }
    }
    
    
    public void setEstado(Long id, EstadoCita estado){

        try{
            Cita cita = em.find(Cita.class, id);
            cita.setEstado(estado);
        }catch(RuntimeException e){         
        }
    }
}
