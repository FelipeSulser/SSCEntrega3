/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
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
    
   
    public Expediente getExpediente(Long id) {
       Expediente exp = em.find(Expediente.class, id);
       
       return exp;
    }
    
    public Ciudadano getCiudadano(Long exp_id){
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
     Expediente exp = em.find(Expediente.class, exp_id);
     if(exp == null) return null;
     return exp.getFamiliares();
    }
       
    public Vivienda getPrincipal(Long exp_id){
          Expediente exp = em.find(Expediente.class, exp_id);
          if(exp == null) return null;
          return exp.getResidencia();
    }
        public List<Vivienda> getSecundarias(Long exp_id){
          Expediente exp = em.find(Expediente.class, exp_id);
          if(exp == null) return null;
          return exp.getViviendas();
    }
       
       
    public void setFamiliar(Long exp_id,Familiar f){
        Expediente exp = em.find(Expediente.class,exp_id);
        if(exp == null) return;
        
        f.setExpediente(exp);
        
        em.persist(f);
        
    }
    
  
    public void setVivienda(Long exp_id, Vivienda v){
        Expediente exp = em.find(Expediente.class, exp_id);
        if(exp == null) return;
        v.setExpediente_residencia(exp);
        
        em.persist(v);
    }
    
    public void setIntervencion(Long exp_id, Long cita_id, Intervenciones inter){
        
        Expediente exp = em.find(Expediente.class,exp_id);
        if(exp == null) return;
        
        Cita c = em.find(Cita.class, cita_id);
        if(c == null) return;
        
        inter.setExpediente(exp);
        inter.setId_cita(c);
        
        em.persist(inter);
    }
       
    
    
    
  
}
