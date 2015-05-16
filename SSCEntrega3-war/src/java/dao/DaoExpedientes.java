/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.Expediente;

/**
 *
 * @author Esteban
 */
public class DaoExpedientes {
    
        private List<Expediente> ef;
        Expediente dummy1,dummy2,dummy3;
        Ciudadano c1,c2,c3;
        
        public DaoExpedientes(){
            
            dummy1= new Expediente();
            dummy2 = new Expediente();
            dummy3 = new Expediente();
            c1 = new Ciudadano();
            c2 = new Ciudadano();
            c3 = new Ciudadano();
                        
            dummy1.setCss("1221");
            dummy2.setCss("2222");
            dummy3.setCss("4232");
            dummy1.setId(new Long(1));
            dummy2.setId(new Long(2));
            dummy3.setId(new Long(3));
            dummy1.setZona("LOS PERALES");
            dummy2.setZona("TORRE DE BENAGALBÓN");
            dummy3.setZona("CARRETERA DE CÁDIZ");
            dummy1.setFecha_apertura(new Date(Calendar.getInstance().getTimeInMillis()));
            dummy2.setFecha_apertura(new Date(Calendar.getInstance().getTimeInMillis()));
            dummy3.setFecha_apertura(new Date(Calendar.getInstance().getTimeInMillis()));
            c1.setApellido1("Pérez");
            c1.setApellido2("Wohlfeil");
            c1.setId(new Long(1));
            c1.setNombre("Esteban");
            c1.setDni("77188676D");
            c1.setNacionalidad("ESPAÑA");
            c1.setImage("profile.png");
            c2.setApellido1("Le Penn");
            c2.setId(new Long(2));
            c2.setNombre("Alberto");
            c2.setDni("11446633Z");
            c2.setNacionalidad("FRANCIA");
            c2.setImage("profile.png");
            c3.setApellido1("John");
            c3.setId(new Long(3));
            c3.setNombre("Jack");
            c3.setDni("11007600A");
            c3.setNacionalidad("USA");
            c3.setImage("profile.png");
            
            dummy1.setCiudadano_exp(c1);
            c1.setExpediente_personal(dummy1);
            
            dummy2.setCiudadano_exp(c2);
            c2.setExpediente_personal(dummy2);
            
            dummy3.setCiudadano_exp(c3);
            c3.setExpediente_personal(dummy3);
            
            ef = new ArrayList();
            ef.add(dummy1);
            ef.add(dummy2);
            ef.add(dummy3);
        }
    
    
       
    public Map<Long, String> getOwnerFromID(){
        //TODO add query select expediente.id, ciudadano.nombre from expediente join ciudadano on expediente.ciudadano_id = ciudadano.id;
        Map<Long,String> expNamesId = new HashMap<Long,String>();
        expNamesId.put(dummy1.getId(), c1.getNombre()+" "+c1.getApellido1());
        expNamesId.put(dummy2.getId(), c2.getNombre()+" "+c2.getApellido1());
        expNamesId.put(dummy3.getId(), c3.getNombre()+" "+c3.getApellido1());
        return expNamesId;
    }
        
    public List<Expediente> getExpedientes(){
        return ef;
    }
    /*
    public List<Expediente> getExpedientes(){
        return null;
    }
    */
}