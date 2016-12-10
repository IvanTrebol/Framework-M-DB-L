/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLExceptions;

/**
 *
 * @author Alberto
 */
public class UPDATEException extends Exception {

    /**
     * Creates a new instance of <code>UPDATEException</code> without detail
     * message.
     */
    public UPDATEException() {
        System.out.println("An error ocurred in the UPDATE operation");
    }

    /**
     * Constructs an instance of <code>UPDATEException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public UPDATEException(String msg) {
        super(msg);
    }
}
