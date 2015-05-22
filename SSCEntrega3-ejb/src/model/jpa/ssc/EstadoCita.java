/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.jpa.ssc;

/**
 *
 * @author haritz
 */
public enum EstadoCita {
    citaPlanificada,    //Verde
    ausencia,   //Rojo
    noRealizada,    //Naranja
    planificadaPorOtroProfesional;   //Violeta
    
    @Override
    public String toString(){
        switch(this){
            case citaPlanificada:
                return "Cita planificada";
            case ausencia:
                return "Ausencia";
            case noRealizada:
                return "No realizada";
            case planificadaPorOtroProfesional:
                return "Planificada por otro profesional";
     
        }
        return null;
    }
}
