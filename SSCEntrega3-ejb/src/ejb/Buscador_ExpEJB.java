/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.jpa.ssc.Expediente;

/**
 *
 * @author Esteban
 * 
 */
@Stateless
@LocalBean
public class Buscador_ExpEJB {
    @PersistenceContext(unitName="SSCPU")
    private EntityManager em;
    
   
    public List<Expediente> getExpedientes(Long id, String apellido1, String apellido2, String nombre) {
       Expediente fake = new Expediente();
       fake.setId(id);
       em.persist(fake);
       
       List<Expediente> lexp = new LinkedList<>();
       Expediente e = getExpById(id);
       if(e!=null) lexp.add(e);
       
       lexp.addAll(getExpByApellido1(apellido1));
       lexp.addAll(getExpByApellido2(apellido2));
       lexp.addAll(getExpByNombre(nombre));
       return lexp;
    }
    
    public Expediente getExpById(Long id){
        if(id != 0){
            return em.find(Expediente.class, id);
        }
        return null;
    }
    
    public List<Expediente> getExpByApellido1(String apellido1){
        if(apellido1 != null){
            //select id,zona from EXPEDIENTE where ciudadano_id = (select id from CIUDADANO where apellido1 = 'PEREZ');
            Query q = em.createQuery("SELECT * FROM EXPEDIENTE where ciudadano_id = (SELECT id FROM CIUDADANO where apellido1 = '"+apellido1+"')");
            return (List<Expediente>) q.getResultList();
        }
        return null;
    }
    
    public List<Expediente> getExpByApellido2(String apellido2){
        if(apellido2 != null){
            Query q = em.createQuery("SELECT * FROM EXPEDIENTE where ciudadano_id = (SELECT id FROM CIUDADANO where apellido2 = '"+apellido2+"')");
            return (List<Expediente>) q.getResultList();
        }
        return null;
    }
    
    public List<Expediente> getExpByNombre(String nombre){
        if(nombre != null){
            Query q = em.createQuery("SELECT * FROM EXPEDIENTE where ciudadano_id = (SELECT id FROM CIUDADANO where nombre = '"+nombre+"')"); 
            return (List<Expediente>) q.getResultList();
        }
        return null;
    }
    /*
    public Map<Long, String> getOwnerFromID(List<Expediente> lexp){
        //TODO add query select expediente.id, ciudadano.nombre from expediente join ciudadano on expediente.ciudadano_id = ciudadano.id;
        Map<Long,String> expNamesId = new HashMap<Long,String>();
        List<Expediente> queryNames = new LinkedList<>();
        Query q = em.createQuery("");
        for(Expediente exp : lexp){
            
        }
        
        expNamesId.put(dummy1.getId(), c1.getNombre()+" "+c1.getApellido1());
        expNamesId.put(dummy2.getId(), c2.getNombre()+" "+c2.getApellido1());
        expNamesId.put(dummy3.getId(), c3.getNombre()+" "+c3.getApellido1());
        return expNamesId;
    }
    */
}
       
