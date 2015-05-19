/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import exceptions.CiudadanoNotFoundException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.jpa.ssc.Cita;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.Profesional;

/**
 *
 * @author haritz
 */
@Stateless
@LocalBean
public class CrearCitaEJB {
    @PersistenceContext(unitName="SSCPU")
    private EntityManager em;
    

    private Ciudadano ciudadano;
    private Profesional profesional;
    

    public Ciudadano getCiudadano(String DNICiudadano) throws CiudadanoNotFoundException {
        try{
            Query query = em.createQuery("SELECT c FROM Ciudadano c WHERE c.dni = :paramDni", Ciudadano.class);
    
            query.setParameter("paramDni", DNICiudadano);
            ciudadano = (Ciudadano) query.getSingleResult();
            return ciudadano;
        } catch(NoResultException e){
            throw new CiudadanoNotFoundException(DNICiudadano);
        }
    }

    public Profesional getProfesional(String DNIProfesional) {
        Query query = em.createQuery("SELECT c FROM Ciudadano c WHERE c.dni = :paramDni", Ciudadano.class);
         Query queryProf = em.createQuery("SELECT p FROM Profesional p WHERE p.dni = :paramDni", Profesional.class);
        queryProf.setParameter("paramDni",DNIProfesional);
        profesional = (Profesional) query.getSingleResult();
        return profesional;
    }

    public void setCita(Cita cita) {
        em.persist(cita);
    }

    public Long getCitaId(Cita cita) {
        cita = em.find(Cita.class, cita);
        return cita.getId();
    }
    
    
}
