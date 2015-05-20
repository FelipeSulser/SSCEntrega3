/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import exceptions.CiudadanoNotFoundException;
import exceptions.ProfesionalNotFoundException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
            String stringQuery = "SELECT c FROM Ciudadano c WHERE c.dni = '"  +DNICiudadano + "'";
            TypedQuery query;   
            query = em.createQuery(stringQuery, Ciudadano.class);
            ciudadano = (Ciudadano) query.getSingleResult();
            return ciudadano;
        } catch(NoResultException e){
            throw new CiudadanoNotFoundException(DNICiudadano);
        }
    }

    public Profesional getProfesional(String DNIProfesional) throws ProfesionalNotFoundException {
        try{
            String stringQuery = "SELECT c FROM Profesional c WHERE c.dni = '"  +DNIProfesional + "'";
            Query query;
            query = em.createQuery(stringQuery, Profesional.class);
            profesional = (Profesional) query.getSingleResult();
            return profesional;
        }catch(NoResultException e){
            throw new ProfesionalNotFoundException(DNIProfesional);
        }
    }

    public void setCita(Cita cita) {
        em.persist(cita);
    }

    public Long getCitaId(Cita cita) {
        cita = em.find(Cita.class, cita);
        return cita.getId();
    }
    
    
}
