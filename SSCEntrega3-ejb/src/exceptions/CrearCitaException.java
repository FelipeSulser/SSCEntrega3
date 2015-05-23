/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Álvaro
 */
public class CrearCitaException extends Exception {

    /**
     * Creates a new instance of <code>CrearCitaException</code> without
     * detail message.
     */
    public CrearCitaException() {
    }

    /**
     * Constructs an instance of <code>CrearCitaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CrearCitaException(String msg) {
        super(msg);
    }
}
