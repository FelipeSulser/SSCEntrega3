/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCita;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.jpa.ssc.Cita;

/**
 *
 * @author felipesulser
 */
@ManagedBean(name="ctrListaCita")
@RequestScoped
public class ControllerListaCitas {
    
    //Los admins pueden ver todas las citas y eliminar cualquier cita!!
    private DaoCita daoCitas;
    
    
    
    private List<Cita> citas;
    
    
    
     @PostConstruct
    public void init() {
        daoCitas = new DaoCita();
        citas = daoCitas.getAllCitas();
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
    
    public String verCita(Long id){
        return "info_cita.xhtml";
    }
    
    
    public void eliminar(Long id) throws IOException{
        //eliminar la cita, por ahora no hace nada
        //TODO add EJB logic
         FacesContext.getCurrentInstance().getExternalContext().redirect("lista_citas.xhtml");
    }
}
