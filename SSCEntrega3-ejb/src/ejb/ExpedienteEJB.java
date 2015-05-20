/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import exceptions.ExpedienteNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.jpa.ssc.Cita;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.Expediente;
import model.jpa.ssc.Familiar;
import model.jpa.ssc.Intervenciones;
import model.jpa.ssc.Vivienda;

/**
 *
 * @author felipeSulser
 */
@Stateless
@LocalBean
public class ExpedienteEJB {
    @PersistenceContext(unitName="SSCPU")
    private EntityManager em;
    
   
    public Expediente getExpediente(Long id) throws ExpedienteNotFoundException {
        if (id == null)
            throw new ExpedienteNotFoundException("No id");
        
        Expediente exp = em.find(Expediente.class, id);
        if(exp == null)
           throw new ExpedienteNotFoundException(Long.toString(id));
        return exp;
    }
    
    public Ciudadano getCiudadano(Long exp_id){ //Añadir CiudadanoNotFoundException!!!!!!!!!!!!
        Expediente exp = em.find(Expediente.class, exp_id);
        if(exp == null) return null;
        return exp.getCiudadano_exp();
    }
    
    public List<Intervenciones> getIntervenciones(Long exp_id){
        Expediente exp = em.find(Expediente.class, exp_id);
        if(exp == null) return null;
        return exp.getIntervenciones();
    }
    
    public List<Familiar> getFamilia(Long exp_id){
        try {
            Expediente exp = getExpediente(exp_id);
            return exp.getFamiliares();
        } catch (ExpedienteNotFoundException ex) {
            return null;
        }
    }
       
    public Vivienda getPrincipal(Long exp_id){
        try {
            Expediente exp = getExpediente(exp_id);
            return exp.getResidencia();
        } catch (ExpedienteNotFoundException ex) {
            return null;
        }
    }
    
    public List<Vivienda> getSecundarias(Long exp_id){
        try {
            Expediente exp = getExpediente(exp_id);
            return exp.getViviendas();

        } catch (ExpedienteNotFoundException ex) {
            return null;
        }
    }
       
       
    public void setFamiliar(Long exp_id,Familiar f){
        Expediente exp;
        try {
            exp = getExpediente(exp_id);
            f.setExpediente(exp);    
            em.persist(f);
        } catch (ExpedienteNotFoundException ex) {
        } 
    }
    
  
    public void setVivienda(Long exp_id, Vivienda v){
        Expediente exp;
        try {
            exp = getExpediente(exp_id);
            v.setExpediente_residencia(exp);
            em.persist(v);
        } catch (ExpedienteNotFoundException ex) {
        }

    }
    
    public void setIntervencion(Long exp_id, Long cita_id, Intervenciones inter){
        Expediente exp;
        try {
            exp = getExpediente(exp_id);
            if(cita_id == null) return;
            Cita c = em.find(Cita.class, cita_id);
            if(c == null) return;
            
            inter.setExpediente(exp);
            inter.setId_cita(c);
        
            em.persist(inter);
        } catch (ExpedienteNotFoundException ex) {
        }
    
    } 
}
