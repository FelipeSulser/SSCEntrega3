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
import javax.persistence.TypedQuery;
import model.jpa.ssc.Cita;

/**
 *
 * @author felipesulser
 */
@Stateless
@LocalBean
public class ListaCitasEJB {

    @PersistenceContext(unitName="SSCPU")
    private EntityManager em;

    public List<Cita> getCitas() {
        TypedQuery<Cita> q = em.createQuery("Select c from Cita c",Cita.class);
        return q.getResultList();     
    }

    public void eliminar(Long id) {
        Cita c = em.find(Cita.class, id);
        if(c != null){
            em.remove(c);
        }
    }

    
}