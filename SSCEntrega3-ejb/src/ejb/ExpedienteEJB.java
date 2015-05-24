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
        System.out.println("estoy en EJB.getFamilia() con id " + exp_id);
        Expediente exp;
        try{   
            exp= em.find(Expediente.class, exp_id);
        }catch(RuntimeException e){
            return null;
        }
        if(exp == null) return null;
        for(Familiar f : exp.getFamiliares()){
            System.out.println(f.getNombre());
        }
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
       
       
    public void setFamiliar(Long exp_id,Familiar f){
        
        Expediente exp;
        try{
            
            exp= em.find(Expediente.class,exp_id);
        }        catch(RuntimeException e){
            return;
        }
            if(exp == null) return;
        
        f.setExpediente_fam(exp);
        
        em.persist(f);
        System.out.println(f.getNombre() + " insertado");
        
    }
    
  
    public void setVivienda(Long exp_id, Vivienda v){
        Expediente exp;
        try{
            exp= em.find(Expediente.class, exp_id);
        }catch(RuntimeException e){
            return;
        }
        if(exp == null) return;
        v.setExpediente_residencia(exp);
        
        em.persist(v);
    }   
  
}
