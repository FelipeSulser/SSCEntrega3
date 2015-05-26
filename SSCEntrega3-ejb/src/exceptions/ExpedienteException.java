/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author felipeS
 */
public class ExpedienteException extends Exception {

    /**
     * Creates a new instance of <code>CrearCitaException</code> without
     * detail message.
     */
    public ExpedienteException() {
    }

    /**
     * Constructs an instance of <code>CrearCitaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExpedienteException(String msg) {
        super(msg);
    }
}
