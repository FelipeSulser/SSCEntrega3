/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import model.jpa.ssc.Ciudadano;
import org.primefaces.model.DefaultScheduleEvent;

/**
 *
 * @author Esteban
 */
public class AdvancedScheduleEvent extends DefaultScheduleEvent{
    private long citaID;
    private String comentarios;
    private String tipo_de_cita;
    private Ciudadano ciudadano;

    
    public AdvancedScheduleEvent(String desc, Date s, Date e, String cssClass, long cita, String coment, String tipocita, Ciudadano c){
        super(desc, s, e, cssClass);
        super.setStyleClass(cssClass);
        citaID = cita;
        comentarios = coment;
        tipo_de_cita = tipocita;
        ciudadano = c;
    }

    AdvancedScheduleEvent() {
        super();
    }
    
    public long getCitaID() {
        return citaID;
    }

    public void setCitaID(int citaID) {
        this.citaID = citaID;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getTipo_de_cita() {
        return tipo_de_cita;
    }

    public void setTipo_de_cita(String tipo_de_cita) {
        this.tipo_de_cita = tipo_de_cita;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }
}
/*
private Long id;
    
    @Column(nullable=false)
    private Date fecha;
    
    
    private String comentarios;

    @Column(nullable=false)
    private String tipo_de_cita;

    
    
    @ManyToOne
    @JoinColumn(nullable=false)
    private Ciudadano ciudadano;

*/