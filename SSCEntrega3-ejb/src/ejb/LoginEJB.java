/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.security.MessageDigest;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.jpa.ssc.Administrativo;
import model.jpa.ssc.Cita;
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
        q.setParameter("name",user).setParameter("contrasenia", password);

        //execute the query and check result
        List<Profesional> result = q.getResultList();
        // No existe el usuario Profesional comprobamos Administrativo
        if(result.isEmpty()){
            //create an ejbql expression
            ejbQL = "Select a from Administrativo a where a.usuario = :name and a.contrasenia = :contrasenia";
            //create query
          TypedQuery<Administrativo> q2 = em.createQuery(ejbQL, Administrativo.class);

           q2.setParameter("name", user).setParameter("contrasenia", hashSHA256(password));
           
          
           List<Administrativo> result2;
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

    public boolean isAdmin() {
        return isAdmin;   
    }

    public Administrativo getAdmin() {
        return admin;    
    }

    public Profesional getPro() {
        return pro;
    }

   

    public Integer getCitasHoy(Profesional pro) {
        //query all of todays dates
          String ejbQL = "Select c from Cita c where (c.fecha BETWEEN :fecha1 AND :fecha2) and c.profesional = :id";
        //create query
        
        TypedQuery<Cita> q = em.createQuery(ejbQL, Cita.class);
        java.sql.Date curr = new java.sql.Date(System.currentTimeMillis());
        
           q.setParameter("id", pro).setParameter("fecha1", addDays(curr,-1)).setParameter("fecha2",addDays(curr,1));
           
          return q.getResultList().size();
        
    }

   public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return new java.sql.Date(cal.getTime().getTime());
    }

    public Integer getTotalIntervenciones(Profesional pro) {
        //query all accumulated interventions
        
        //mas rapido con count, pero por ahora lo hacemos asi
          String ejbQL = "Select c from Cita c where c.profesional = :id and c.fecha < CURRENT_DATE";
        //create query
        TypedQuery<Cita> q = em.createQuery(ejbQL, Cita.class);
        q.setParameter("id", pro);
        
        return q.getResultList().size();
        
        
    }
    
}
