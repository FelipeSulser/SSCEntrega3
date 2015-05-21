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
public class ProfesionalNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>ProfesionalNotFoundException</code>
     * without detail message.
     */
    public ProfesionalNotFoundException() {
    }

    /**
     * Constructs an instance of <code>ProfesionalNotFoundException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ProfesionalNotFoundException(String msg) {
        super(msg);
    }
}
