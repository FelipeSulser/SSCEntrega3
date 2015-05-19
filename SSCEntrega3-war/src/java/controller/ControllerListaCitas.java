/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCita;
import ejb.ListaCitasEJB;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import model.jpa.ssc.Cita;

/**
 *
 * @author felipesulser
 */
@Named(value="ctrListaCita")
@RequestScoped
public class ControllerListaCitas {
    
    //Los admins pueden ver todas las citas y eliminar cualquier cita!!
   
    @Inject
    private ListaCitasEJB listaCitas;
    
    
    
    private List<Cita> citas;
    
    
    
    

    public List<Cita> getCitas() {
        citas = listaCitas.getCitas();
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
    
    public String verCita(Long id){
        
        //TO_DO, pasarle al Backing bean de info cita la ID de la cita
        return "info_cita.xhtml";
    }
    
    
    public void eliminar(Long id) throws IOException{
        listaCitas.eliminar(id);
         FacesContext.getCurrentInstance().getExternalContext().redirect("lista_citas.xhtml");
    }
}
