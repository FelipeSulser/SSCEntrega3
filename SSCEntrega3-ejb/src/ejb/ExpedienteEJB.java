/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import exceptions.ExpedienteException;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
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
         Expediente exp;
        try{
            exp= em.find(Expediente.class, id);
        }catch(RuntimeException e){
            return null;
        }
       
       return exp;
    }
    
    public Ciudadano getCiudadano(Long exp_id){
        Expediente exp ;
    
        try{
        exp= em.find(Expediente.class, exp_id);
        }catch(RuntimeException e){
            return null;
        }
        if(exp == null) return null;
        return exp.getCiudadano_exp();
    }
    
    public List<Intervenciones> getIntervenciones(Long exp_id){
        Expediente exp;
        try{
            exp= em.find(Expediente.class, exp_id);
        }catch(RuntimeException e){
            return null;
        }
            if(exp == null) return null;
        return exp.getIntervenciones();
    }
    
    public List<Familiar> getFamilia(Long exp_id){
        
     Expediente exp;
     try{   
        exp= em.find(Expediente.class, exp_id);
     }catch(RuntimeException e){
         return null;
     }
        if(exp == null) return null;
     return exp.getFamiliares();
    }
       
    public Vivienda getPrincipal(Long exp_id){
          Expediente exp;
          try{
            exp= em.find(Expediente.class, exp_id);
          }catch(RuntimeException e){
              return null;
          }
          if(exp == null) return null;
          return exp.getResidencia();
    }
        public List<Vivienda> getSecundarias(Long exp_id){
          Expediente exp;
            try{
            
                exp= em.find(Expediente.class, exp_id);
            }catch(RuntimeException e){
                return null;
            }
                if(exp == null) return null;
          return exp.getViviendas();
    }
       
       
    public void setFamiliar(Long exp_id,Familiar f) throws ExpedienteException{
        
        Expediente exp;
        try{
            
            exp= em.find(Expediente.class,exp_id);
        }        catch(RuntimeException e){
            throw new ExpedienteException();
            
        }
            if(exp == null) return;
        try{
            
        f.setExpediente(exp);
        
        em.persist(f);
        em.flush();
        
        }catch(PersistenceException e){
            throw new ExpedienteException("Ya existe esa cita.");
        }catch(IllegalArgumentException e ){
            throw new ExpedienteException("Error al crear la cita.");
        }
        
    }
    
  
    public void setVivienda(Long exp_id, Vivienda v) throws ExpedienteException{
        Expediente exp;
        try{
            exp= em.find(Expediente.class, exp_id);
        }catch(RuntimeException e){
            throw new ExpedienteException();
        }
        if(exp == null) return;
        try{
           
       
        v.setPropietario(exp);
        
        em.persist(v);
         }catch(EntityExistsException e){
            throw new ExpedienteException("Ya existe esa cita.");
        }catch(IllegalArgumentException | TransactionRequiredException e ){
            throw new ExpedienteException("Error al crear la cita.");
        }
    }   
  
}
