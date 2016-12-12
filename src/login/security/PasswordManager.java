package login.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.swing.JOptionPane;
import login.exceptions.UnsafePasswordException;
/**
 *
 * @author Evan-Ian-Ray
 */
public final class PasswordManager {
    
    public PasswordManager(){
    }
    
    public void passwordSafeChecker(String input_NewPassword ) throws UnsafePasswordException{
        
        char[] cArray = input_NewPassword.toCharArray();
        char[] numArray = input_NewPassword.replaceAll("[^0-9]","").toCharArray();
        
        try{
        if( cArray.length == 0 ){
            throw new UnsafePasswordException("Password is not safe");
        }
        if( cArray.length <= 8 ){
            throw new UnsafePasswordException("Password is not safe");
            }    
        if( numArray.length == 0){
            throw new UnsafePasswordException("Password is not safe");
        }
            
        }
        catch(UnsafePasswordException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
    }
    
    /**
     * This class takes the parameter input_Password, encrypts it, and returns it.
     * @param input_Password
     * @return
     */
    public String encryptPassword( String input_Password ) {
        
        Base64.Encoder PasswordEncoder = Base64.getEncoder();
        String outputEncryptedPassword = PasswordEncoder.encodeToString( 
            input_Password.getBytes( StandardCharsets.UTF_8 ) 
        );
        return outputEncryptedPassword;
    }
}
