/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.jpa.ssc.Ciudadano;
import model.jpa.ssc.Expediente;
import model.jpa.ssc.Familiar;
import model.jpa.ssc.Intervenciones;
import model.jpa.ssc.Vivienda;

/**
 *
 * @author felipesulser
 */
public class DaoExpedienteView {
   

   
    private Expediente expediente;
    private Ciudadano ciudadano;
    private List<Intervenciones> intervenciones;
    private List<Familiar> familia;
    private Vivienda principal;
    private List<Vivienda> secundarias;
    
    
    private Long id;
    
    
    public DaoExpedienteView() {
       
       
        
       
        
    }

    public DaoExpedienteView(Long id) {
        //Dummy
        this.id = id;
        expediente= new Expediente();
        expediente.setId(id);
           
            
            expediente.setCss("212");
            
           expediente.setId(new Long(12112));
           
            
            expediente.setFecha_apertura(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            
           
      
        ciudadano = new Ciudadano();
        ciudadano.setNombre("Hans");
        ciudadano.setApellido1("Jürg");
        ciudadano.setApellido2("Maxsen");
        ciudadano.setDni("1212323");
        ciudadano.setNacionalidad("Suizo");
        ciudadano.setFecha_nacimiento(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        ciudadano.setImage("profile.png");
        principal = new Vivienda();
        principal.setCalle("Calle Corta");
        principal.setCodigoPostal("29730");
        
        Intervenciones i1 = new Intervenciones();
        i1.setAnotaciones("Paciente enfermo de SIDA");
        i1.setFecha(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        intervenciones = new ArrayList();
        intervenciones.add(i1);
        
        
        Familiar primo = new Familiar();
        primo.setApellido1("Gustavo");
        primo.setApellido2("Adolfo");
        primo.setMu("MUUUU");
        primo.setFecha_nacimiento(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        primo.setNombre("Sam");
        primo.setParentesco("Primo");
        primo.setDni("78986352H");
     
        familia = new ArrayList();
        familia.add(primo);
        
        Familiar padre = new Familiar();
        padre.setNombre("Maximilian");
        padre.setApellido1("Zimmerman");
        padre.setDni("2182218D");
        padre.setParentesco("Padre");
        familia.add(padre);
        
        Vivienda casa = new Vivienda();
        
        
        secundarias = new ArrayList();
        
        casa.setCalle("Calle Enrique VII");
        casa.setCodigoPostal("2920");
        casa.setMetros_cuadrados("22");
       
        
        secundarias.add(casa);
       
    }



    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public List<Intervenciones> getIntervenciones() {
        return intervenciones;
    }

    public void setIntervenciones(List<Intervenciones> intervencion) {
        this.intervenciones = intervencion;
    }
   

    public List<Familiar> getFamilia() {
        return familia;
    }

    public void setFamilia(List<Familiar> familia) {
        this.familia = familia;
    }

    public Vivienda getPrincipal() {
        return principal;
    }

    public void setPrincipal(Vivienda principal) {
        this.principal = principal;
    }

    public List<Vivienda> getSecundarias() {
        return secundarias;
    }

    public void setSecundarias(List<Vivienda> secundarias) {
        this.secundarias = secundarias;
    }
    
}
