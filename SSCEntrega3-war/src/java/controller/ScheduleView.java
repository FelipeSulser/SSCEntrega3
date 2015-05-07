/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.jpa.ssc.Ciudadano;
 

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
 
/**
 *
 * @author Esteban
 */

@ManagedBean
@ViewScoped
public class ScheduleView implements Serializable {
 
    private ScheduleModel eventModel; 
 
    private ScheduleEvent event = new AdvancedScheduleEvent();
    
 
    @PostConstruct
    public void init() {
        Ciudadano c = new Ciudadano();
        c.setNombre("Esteban");
        eventModel = new DefaultScheduleModel();
        Date start = anyDay(5,7);
        Date end = anyDay(5,9);
        //String desc, Date s, Date e, int cita, String coment, String tipocita, Ciudadano c)
        eventModel.addEvent(new AdvancedScheduleEvent("Fontanería básica", start, end, "cssCitaPlanificada", 1, "Llevar llave inglesa", "RUTINA/CHEQUEO",c));
        start = anyDay(10,5);
        end = anyDay(10,10);
        eventModel.addEvent(new AdvancedScheduleEvent("Atención 3ª edad", start, end, "cssCitaAusencia", 2, "", "CUIDADOS", c));
        start = anyDay(7,4);
        end = anyDay(7,5);
        eventModel.addEvent(new AdvancedScheduleEvent("Revisión sanitaria", start, end, "cssCitaOtroProfesional", 3, "", "REVISION", c));
 
    }
    public ScheduleModel getEventModel() {
        return eventModel;
    }     
    public ScheduleEvent getEvent() {
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    public void addEvent(ActionEvent actionEvent) {
        eventModel.updateEvent(event);
        event = new DefaultScheduleEvent();
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
    
    private Date anyDay(int day, int hour) {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + day);
        t.set(Calendar.HOUR, hour);
         
        return t.getTime();
    }
 
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
