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
public class CiudadanoNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>CiudadanoNotFoundException</code> without
     * detail message.
     */
    public CiudadanoNotFoundException() {
    }

    /**
     * Constructs an instance of <code>CiudadanoNotFoundException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CiudadanoNotFoundException(String msg) {
        super(msg);
    }
}
