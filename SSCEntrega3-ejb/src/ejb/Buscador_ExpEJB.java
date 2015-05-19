/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
 * @author Esteban
 * 
 */
@Stateless
@LocalBean
public class Buscador_ExpEJB {
    @PersistenceContext(unitName="SSCPU")
    private EntityManager em;
    
   
    public List<Expediente> getExpedientes(Long id, String apellido1, String apellido2, String nombre) {
        List<Expediente> exps = new ArrayList();
      if(id != null && !id.equals(new Long(0))){
          
          //si proporciona una id, la búsqueda se hace por id
      Expediente onlyOne = em.find(Expediente.class,id);
      exps.add(onlyOne);
      return exps;
               
      }else{
         
          //now do all queries by parameters
          if(apellido1.equals("") && apellido2.equals("") && nombre.equals("")){
              return exps;
          }
          if(apellido1.equals("") && apellido2.equals("")){
              TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.nombre) = UPPER(:nombre)",Ciudadano.class);
              for(Ciudadano s : q.setParameter("nombre", nombre).getResultList()){
                  exps.add(s.getExpediente_personal());
              }
              return exps;
          }
          if(apellido1.equals("") && nombre.equals("")){
               TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.apellido2) = UPPER(:nombre)",Ciudadano.class);
              for(Ciudadano s : q.setParameter("nombre", apellido2).getResultList()){
                  exps.add(s.getExpediente_personal());
              }
              return exps;
          }
          if(apellido2.equals("") && nombre.equals("")){
                 TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.apellido2) = UPPER(:nombre)",Ciudadano.class);
              for(Ciudadano s : q.setParameter("nombre", apellido1).getResultList()){
                  exps.add(s.getExpediente_personal());
              }
              return exps;
          }
          if(apellido2.equals("")){
               TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.nombre) = UPPER(:nombre) AND UPPER(c.apellido1) = UPPER(:ap)",Ciudadano.class);
              for(Ciudadano s : q.setParameter("nombre", nombre).setParameter("ap", apellido1).getResultList()){
                  exps.add(s.getExpediente_personal());
              }
              return exps;
          }
          if(apellido1.equals("")){
              TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.nombre) = UPPER(:nombre) AND UPPER(c.apellido2) = UPPER(:ap)",Ciudadano.class);
              for(Ciudadano s : q.setParameter("nombre", nombre).setParameter("ap", apellido2).getResultList()){
                  exps.add(s.getExpediente_personal());
              }
              return exps;
          }
          if(nombre.equals("")){
               TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.apellido1) = UPPER(:nombre) AND UPPER(c.apellido2) = UPPER(:ap)",Ciudadano.class);
              for(Ciudadano s : q.setParameter("nombre", apellido1).setParameter("ap", apellido2).getResultList()){
                  exps.add(s.getExpediente_personal());
              }
              return exps;
          }
      }
      return exps;
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

    public String getNombre(Long id) {
        TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where c.expediente_personal.id = :idx",Ciudadano.class);
            q.setParameter("idx", id);
                 Ciudadano ciu = q.getSingleResult();
              return ciu.getNombre() +" "+ciu.getApellido1()+" "+ciu.getApellido2();
    }

    public Map<Long,Ciudadano> getCiudadanos(Long id, String apellido1, String apellido2, String nombre) {
       List<Ciudadano> exps = new ArrayList();
       Map<Long,Ciudadano> myMap = new HashMap();
      if(id != null && !id.equals(new Long(0))){
          
          //si proporciona una id, la búsqueda se hace por id
       TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where c.expediente_personal.id = :idx",Ciudadano.class);
       q.setParameter("idx", id);
       List<Ciudadano> lista = q.getResultList();
       if(lista == null || lista.isEmpty()) return myMap;
       Ciudadano ciu = q.getSingleResult();
       myMap.put(ciu.getExpediente_personal().getId(), ciu);
      return myMap;
               
      }else{
          //now do all queries by parameters
          if(apellido1.equals("") && apellido2.equals("") && nombre.equals("")){
              return myMap;
          }
          if(apellido1.equals("") && apellido2.equals("")){
              TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.nombre) = UPPER(:nombre)",Ciudadano.class);
              for(Ciudadano ci :q.setParameter("nombre", nombre).getResultList()){
                  myMap.put(ci.getExpediente_personal().getId(), ci);
              }
             return myMap;
          }
          if(apellido1.equals("") && nombre.equals("")){
               TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.apellido2) = UPPER(:nombre)",Ciudadano.class);
               
               List<Ciudadano> li = q.setParameter("nombre", apellido2).getResultList();
               for(Ciudadano ci : li){
                   myMap.put(ci.getExpediente_personal().getId(),ci);
               }
               return myMap;
          }
          if(apellido2.equals("") && nombre.equals("")){
                 TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.apellido2) = UPPER(:nombre)",Ciudadano.class);
                  List<Ciudadano> li =  q.setParameter("nombre", apellido1).getResultList();
                  for(Ciudadano ci: li){
                      myMap.put(ci.getExpediente_personal().getId(), ci);
                  }
                return myMap;
          }
          if(apellido2.equals("")){
               TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.nombre) = UPPER(:nombre) AND UPPER(c.apellido1) = UPPER(:ap)",Ciudadano.class);
               List<Ciudadano> li =  q.setParameter("nombre", nombre).setParameter("ap", apellido1).getResultList();
               for(Ciudadano ci: li){
                   myMap.put(ci.getExpediente_personal().getId(), ci);
               }
               return myMap;
                
          }
          if(apellido1.equals("")){
              TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.nombre) = UPPER(:nombre) AND UPPER(c.apellido2) = UPPER(:ap)",Ciudadano.class);
             List<Ciudadano> li =  q.setParameter("nombre", nombre).setParameter("ap", apellido2).getResultList();
             for(Ciudadano ci : li){
                 myMap.put(ci.getExpediente_personal().getId(),ci);
             }
             return myMap;
                  
          }
          if(nombre.equals("")){
               TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.apellido1) = UPPER(:nombre) AND UPPER(c.apellido2) = UPPER(:ap)",Ciudadano.class);
               List<Ciudadano> li =  q.setParameter("nombre", apellido1).setParameter("ap", apellido2).getResultList();
               for(Ciudadano ci: li){
                   myMap.put(ci.getExpediente_personal().getId(),ci);
               }
               return myMap;
          }
      }
      return myMap;   
    }

  
}
       
