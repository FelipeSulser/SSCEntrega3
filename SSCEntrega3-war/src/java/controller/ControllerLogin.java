package controller;


import ejb.LoginEJB;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.context.FacesContext;
import javax.inject.Named;
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
@Named(value="ctrLogin")
@SessionScoped
public class ControllerLogin implements Serializable{
    //Injected
    @EJB
    private LoginEJB loginBean;
    
    
    
    private String nombreDeUsuario;
    private boolean isAdmin;
    
    private Administrativo admin;
    private Profesional pro;
    private boolean isLogged;
    
    private String dni;
    private String image;
    private String user;
   
    
    public boolean isLoggedIn(){
        return isLogged;
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
        boolean existe = loginBean.existeUsuario(username, password);
        if(!existe){
            isLogged = false;
            // We put a message inside the flash
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("message",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "La combinación usuario/contraseña no es correcta",""));
            // We redirect to the login page
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }else
        {   isLogged = true;
            isAdmin = loginBean.isAdmin();
            if(isAdmin){
                admin = loginBean.getAdmin();
               /* sesionB.setAdmin(admin);
                sesionB.setIsAdmin(true);*/
                nombreDeUsuario = admin.getNombre()+" "+admin.getApellido1()+" "+admin.getApellido2();
                dni = admin.getDni();
                user = admin.getUsuario();
                image = admin.getImage();
            
                 FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }else{
            pro = loginBean.getPro();
            
            nombreDeUsuario = pro.getNombre()+" "+pro.getApellido1()+" "+pro.getApellido2();
            dni = pro.getDni();
            user = pro.getUsuario();
            image = pro.getImage();
           
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }
            
        }
        // if user validates, we continue navigation
        
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public LoginEJB getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginEJB loginBean) {
        this.loginBean = loginBean;
    }

  

    public Administrativo getAdmin() {
        return admin;
    }

    public void setAdmin(Administrativo admin) {
        this.admin = admin;
    }

    public Profesional getPro() {
        return pro;
    }

    public void setPro(Profesional pro) {
        this.pro = pro;
    }

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

  
    
    
}