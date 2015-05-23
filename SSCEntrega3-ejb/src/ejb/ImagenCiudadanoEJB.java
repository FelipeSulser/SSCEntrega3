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
import model.jpa.ssc.Ciudadano;

/**
 *
 * @author Esteban
 */
@Stateless
@LocalBean
public class ImagenCiudadanoEJB {
    @PersistenceContext(unitName="SSCPU")
    private EntityManager em;
    
    public String getImageFromCitizen(long id){
        Ciudadano citizen = em.find(Ciudadano.class, id);
        if(citizen.getImage() == null){
            return "profile.png";
        }
        return citizen.getImage();
    }
    
}
