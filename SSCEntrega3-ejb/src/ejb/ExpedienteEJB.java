/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.Expediente;

/**
 *
 * @author Swissmate
 */
@Stateless
@LocalBean
public class ExpedienteEJB {
    @PersistenceContext(unitName="SSCPU")
    private EntityManager em;
    
    private Long id;

    
    public void setExpediente(Long id){
        this.id = id;
    }
    public Expediente getExpediente(Long id) {
        
       
      TypedQuery<Expediente> query = em.createNamedQuery("Expediente.GET_EXP",Expediente.class).setParameter("id", id);
      return query.getSingleResult();
    }
    
    public Ciudadano getCiudadano(Long exp_id){
        return null;
    }
    
    
  
}
