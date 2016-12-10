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
public class SELECTException extends Exception {

    /**
     * Creates a new instance of <code>SELECTException</code> without detail
     * message.
     */
    public SELECTException() {
        System.out.println("An error ocurred in the SELECT operation");
    }

    /**
     * Constructs an instance of <code>SELECTException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SELECTException(String msg) {
        super(msg);
    }
}
