/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.jpa.ssc;

import java.io.Serializable;
import java.util.List;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
 
/**
 *
 * @author Grupo E
 */
@Entity

public class Expediente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(nullable=false)
    private String css;
    @Column(nullable=false)
    private String zona;
    @Column(nullable=false)
    private Date fecha_apertura;

    @OneToMany(mappedBy = "propietario")
    private List<Vivienda> viviendas;

    @OneToOne(mappedBy="expediente_residencia")
    private Vivienda residencia;
    
    @OneToMany(mappedBy = "expediente_fam")
    private List<Familiar> familiares;
    
    @OneToMany(mappedBy="intervenciones_exp", orphanRemoval=true)
    private List<Intervenciones> intervenciones;

    
    @OneToOne
    @JoinColumn(nullable=false)
    private Ciudadano ciudadano_exp;
    
    public Vivienda getResidencia() {
        return residencia;
    }

    public void setResidencia(Vivienda residencia) {
        this.residencia = residencia;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public List<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(List<Familiar> familiares) {
        this.familiares = familiares;
    }

    
    public List<Intervenciones> getIntervenciones() {
        return intervenciones;
    }

    public void setIntervenciones(List<Intervenciones> intervenciones) {
        this.intervenciones = intervenciones;
    }

    public Ciudadano getCiudadano_exp() {
        return ciudadano_exp;
    }

    public void setCiudadano_exp(Ciudadano ciudadano_exp) {
        this.ciudadano_exp = ciudadano_exp;
    }
    public Expediente(){
        
    }
    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    
    

    public List<Vivienda> getViviendas() {
        return viviendas;
    }

    
    public void setViviendas(List<Vivienda> viviendas) {
        this.viviendas = viviendas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Date fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
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
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.sercsocial.Expediente[ id=" + id + " ]";
    }
    
}
