/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.security.MessageDigest;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Adrian
 */
@Stateless
@LocalBean
public class LoginEJB {
    @PersistenceContext(unitName="SSCPU")
    private EntityManager em;

    /**
     * Metodo que dado un usuario/contrasena devuelve si el usuario existe en la BD
     * @param user
     * @param password
     * @return Profesional, Administrativo or null
     */    
    public Object existeUsuario(String user, String password){
        //create an ejbql expression
        String ejbQL = "From Profesional p where p.usuario = ?1 and p.contrasenia = ?2";
        //create query
        Query query = em.createQuery(ejbQL);
        query.setParameter(1, user);
        query.setParameter(2, hashSHA256(password));
        //execute the query and check result
        List result = query.getResultList();
        // No existe el usuario Profesional comprobamos Administrativo
        if(result.isEmpty()){
            //create an ejbql expression
            ejbQL = "From Administrativo a where a.usuario = ?1 and a.contrasenia = ?2";
            //create query
            query = em.createQuery(ejbQL);
            query.setParameter(1, user);
            query.setParameter(2, hashSHA256(password));
            // Comprobamos resultado Si no, no existe usuario
            result = query.getResultList();
            if(result.isEmpty()) return null; // no existe usuario
            else return result.get(0); // devolvemos el Administrativo
        } else return result.get(0); // devolvemos el Profesional
    }
    
    private String hashSHA256(String text){
        MessageDigest md=null;
        try{
            md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes());
        }catch(Exception e){}
        return bytesToHex(md.digest());
    }
    
    private String bytesToHex(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
         sb.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
}
