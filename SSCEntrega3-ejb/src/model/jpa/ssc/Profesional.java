/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.jpa.ssc;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Grupo E
 */
@Entity
public class Profesional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique=true,nullable=false)
    private String dni;
    
    @Column(nullable=false)
    private String usuario;
    
    /**
     * Para mejorarlo, podríamos tener 256 bytes y
     * guardar el SHA2(256) de ese campo y compararlo
     */
    @Column(nullable=false)
    private String contrasenia;
    
    @Column(nullable=false)
    private String nombre;
    
    @Column(nullable=false)
    private String apellido1;
    
    private String apellido2;
    
    private String image;
    
    @OneToMany(mappedBy="profesional",orphanRemoval=true)
    private List<Cita> citas;

    
    
    public Profesional(){
        
    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public void setNombre(String n){
        nombre = n;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setApellido1(String n){
        apellido1 = n;
    }
    public String getApellido1(){
        return apellido1;
    }
    public void setDni(String dn){
        dni = dn;
    }
    public String getDni(){
        return dni;
    }
    public void setApellido2(String n){
        apellido2 = n;
        
    }
    
    public String getApellido2(){
        return apellido2;
    }
    
    public String getNombreCompleto(){
        return nombre+" "+apellido1+" "+apellido2;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public String getImage(){
        return image;
    }
    public void setImage(String img){
        this.image = img;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesional)) {
            return false;
        }
        Profesional other = (Profesional) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "jpa.sercsocial.Profesional[ id=" + id + " ]";
    }
    
}
