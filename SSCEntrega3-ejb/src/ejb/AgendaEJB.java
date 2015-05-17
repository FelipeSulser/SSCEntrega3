/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.jpa.ssc.Cita;

/**
 *
 * @author Esteban
 */
@Stateless
@LocalBean
public class AgendaEJB {
    @PersistenceContext(unitName="SSCPU")
    private EntityManager em;

    public List<Cita> getCitas(long idProfesional){
        List<Cita> l = new LinkedList<>();
        TypedQuery<Cita> q = em.createQuery("Select c from Cita c where PROFESIONAL_ID = :idProf",Cita.class);
        for(Cita c : q.setParameter("idProf", idProfesional).getResultList()){
            l.add(c);
        }
        return l;
    }
}

/*
if(apellido1.equals("") && apellido2.equals("")){
              TypedQuery<Ciudadano> q = em.createQuery("Select c from Ciudadano c where UPPER(c.nombre) = UPPER(:nombre)",Ciudadano.class);
              for(Ciudadano s : q.setParameter("nombre", nombre).getResultList()){
                  exps.add(s.getExpediente_personal());
              }
              return exps;
*/
