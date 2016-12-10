package mapping.exceptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gerry
 */
public class TableEmptyException extends Exception{
    //Parameterless Constructor
    public TableEmptyException() {}

    //Constructor that accepts a message
    public TableEmptyException(String message){
        super(message);
    }
}
