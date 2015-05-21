package controller;


import ejb.LoginEJB;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.jpa.ssc.Administrativo;
import model.jpa.ssc.Profesional;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felipesulser
 */
@ManagedBean(name="ctrLogin")
@SessionScoped
public class ControllerLogin implements Serializable{
    //Injected
    @EJB
    private LoginEJB loginBean;
    
    private String nombreDeUsuario;
    private boolean isAdmin;
   
    
    public boolean isLoggedIn(){
        return nombreDeUsuario != null;
    }
    
    public String logOut(){
        nombreDeUsuario = null;
        return "index.xhtml";
    }
    
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }
    
    public void autenticar(String username, String password) throws IOException{
        Object usuario = loginBean.existeUsuario(username, password);
        // if user validates, we continue navigation
        if(usuario instanceof Profesional){ // Profesional
            this.setIsAdmin(false);
            this.setNombreDeUsuario(((Profesional) usuario).getNombreCompleto());
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        // else we return to the login page
        }else if(usuario instanceof Administrativo){ //Administrativo
            this.setIsAdmin(true);
            this.setNombreDeUsuario(((Administrativo) usuario).getNombreCompleto());
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }else{
            // We put a message inside the flash
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("message",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "La combinación usuario/contraseña no es correcta",""));
            // We redirect to the login page
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

  
    
    
}