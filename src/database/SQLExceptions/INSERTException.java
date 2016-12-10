/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.SQLExceptions;

/**
 *
 * @author Alberto
 */
public class INSERTException extends Exception {

    /**
     * Creates a new instance of <code>INSERTException</code> without detail
     * message.
     */
    public INSERTException() {
        System.out.println("An error ocurred in the INSERT operation");
    }

    /**
     * Constructs an instance of <code>INSERTException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public INSERTException(String msg) {
        super(msg);
    }
}
