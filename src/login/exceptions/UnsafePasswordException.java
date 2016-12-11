package login.exceptions;

/**
 *
 * @author Evan-Ian-Ray
 */
public class UnsafePasswordException extends Exception{
    
    public UnsafePasswordException( ){
        ;
    }
    
    public UnsafePasswordException( String message ){
        
        super( message );
    }
}
