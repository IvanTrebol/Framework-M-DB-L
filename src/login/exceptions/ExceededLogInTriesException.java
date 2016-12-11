/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.exceptions;

/**
 *
 * @author Evan-Ian-Ray
 */
public class ExceededLogInTriesException extends Exception{
    
    public ExceededLogInTriesException(){
        ;
    }
    
    public ExceededLogInTriesException( String message ){
        
        super( message );
    }
}
