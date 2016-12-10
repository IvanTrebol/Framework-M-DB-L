/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping.exceptions;

/**
 *
 * @author Gerry
 */
public class ListEmptyException extends Exception{
    public ListEmptyException() {}

    //Constructor that accepts a message
    public ListEmptyException(String message){
        super(message);
    }
}
