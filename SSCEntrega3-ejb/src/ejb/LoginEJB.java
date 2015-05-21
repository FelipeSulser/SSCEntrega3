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
import javax.persistence.TypedQuery;
import model.jpa.ssc.Administrativo;
import model.jpa.ssc.Profesional;

/**
 *
 * @author Adrian
 */
@Stateless
@LocalBean
public class LoginEJB {
    @PersistenceContext(unitName="SSCPU")
    private EntityManager em;
    
    private Profesional pro;
    private Administrativo admin;
    private boolean isAdmin;

    /**
     * Metodo que dado un usuario/contrasena devuelve si el usuario existe en la BD
     * @param user
     * @param password
     * @return Profesional, Administrativo or null
     */    
    public boolean existeUsuario(String user, String password){
        //create an ejbql expression
        String ejbQL = "Select p from Profesional p where p.usuario = :name and p.contrasenia = :contrasenia";
        //create query
        TypedQuery<Profesional> q = em.createQuery(ejbQL, Profesional.class);
        q.setParameter("name",user).setParameter("contrasenia", hashSHA256(password));

        //execute the query and check result
        List<Profesional> result = q.getResultList();
        // No existe el usuario Profesional comprobamos Administrativo
        if(result.isEmpty()){
            //create an ejbql expression
            ejbQL = "Select a from Administrativo a where a.usuario = :name and a.contrasenia = :contrasenia";
            //create query
          TypedQuery<Administrativo> q2 = em.createQuery(ejbQL, Administrativo.class);

           q.setParameter("name", user).setParameter("contrasenia", hashSHA256(password));
           List<Administrativo> result2 = q2.getResultList();
            // Comprobamos resultado Si no, no existe usuario
            result2 = q2.getResultList();
            if(result2.isEmpty()) return false; // no existe usuario
            
            else{
                admin = result2.get(0);
                isAdmin = true;
                return true;
            } // devolvemos el Administrativo
        }
        isAdmin = false;
        pro = result.get(0);
        return true;
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
