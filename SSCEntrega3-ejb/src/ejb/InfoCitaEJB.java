/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import exceptions.CrearIntervencionException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.jpa.ssc.Cita;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.EstadoCita;
import model.jpa.ssc.Expediente;
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
        Cita cita;
        
        try{
            cita = em.find(Cita.class, id);
        }catch(RuntimeException e){
            return null;
        }
        
        if(cita==null) return null;
        else return cita.getFecha();
        
    }
    
    public String getComentarios(Long id){
        Cita cita;
        
        try{
            cita = em.find(Cita.class, id);
        }catch(RuntimeException e){
            return null;
        }
        
        if(cita==null) return null;
        else return cita.getComentarios();
    }
    
    public String getTipo_de_cita(Long id){
        Cita cita;
        
        try{
            cita = em.find(Cita.class, id);
        }catch(RuntimeException e){
            return null;
        }
        
        if(cita==null) return null;
        return cita.getTipo_de_cita();
    }
    
    public Ciudadano getCiudadano(Long id){
        Cita cita;
        
        try{
            cita = em.find(Cita.class, id);
        }catch(RuntimeException e){
            return null;
        }
        
        if(cita==null) return null;
        else return cita.getCiudadano();
    }
    
    public Profesional getProfesional(Long id){
        Cita cita;
        
        try{
            cita = em.find(Cita.class, id);
        }catch(RuntimeException e){
            return null;
        }
        
        if(cita==null) return null;
        else return cita.getProfesional();
    }
    
    public List<Intervenciones> getIntervenciones(Long id){
        Cita cita;
        
        try{
            cita = em.find(Cita.class, id);
        }catch(RuntimeException e){
            return null;
        }
        
        if(cita==null) return null;
        else return cita.getIntervenciones();
    }
    
    
    public EstadoCita getEstado(Long id){
        Cita cita;
        
        try{
            cita = em.find(Cita.class, id);
        }catch(RuntimeException e){
            return null;
        }
        
        if(cita==null) return null;
        else return cita.getEstado();
    }
    
    
    public void setEstado(Long id, EstadoCita estado){
        Cita cita;
        
        try{
            cita = em.find(Cita.class, id);
        }catch(RuntimeException e){
            return;
        }
        
        if(cita != null){
            cita.setEstado(estado);
        }
    }

    public void setIntervencion(Long exp_id, Long cita_id, Intervenciones inter) throws CrearIntervencionException{
        if(exp_id == null) throw new CrearIntervencionException();
        
        Expediente exp;
        try{
            exp= em.find(Expediente.class,exp_id);
        }catch(RuntimeException e){
            throw new CrearIntervencionException();
        }
        if(exp == null || cita_id == null) return;
        Cita c;
        try{
            c= em.find(Cita.class, cita_id);
        }catch(RuntimeException e){
            throw new CrearIntervencionException();
        }
        if(c == null) return;
        
        inter.setExpediente(exp);
        inter.setId_cita(c);
        try{
            em.persist(inter);
            List<Intervenciones> listaInter = c.getIntervenciones();
            if(listaInter == null){
                listaInter = new ArrayList<Intervenciones>();
            }
            listaInter.add(inter);
            c.setIntervenciones(listaInter);
        } catch (RuntimeException e){
            throw new CrearIntervencionException();
        }
    }
}
