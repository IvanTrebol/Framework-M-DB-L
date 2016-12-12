package login.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
/**
 *
 * @author Evan-Ian-Ray
 */
public final class PasswordManager {
    
    public PasswordManager(){
    }
    
    private void passwordSafeChecker(String input_NewPassword ){
        
        char[] cArray = input_NewPassword.toCharArray();
        if( cArray.length != 0 ){
            
            if( cArray.length >= 8 ){
                
                for (int i = 0; i < cArray.length; i++) {
                    char d = cArray[i];
                }
            }
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
