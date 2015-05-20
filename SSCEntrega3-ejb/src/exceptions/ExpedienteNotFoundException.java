/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author haritz
 */
public class ExpedienteNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>ExpedienteNotFoundException</code>
     * without detail message.
     */
    public ExpedienteNotFoundException() {
    }

    /**
     * Constructs an instance of <code>ExpedienteNotFoundException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExpedienteNotFoundException(String msg) {
        super(msg);
    }
}
