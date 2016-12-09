package login.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
/**
 *
 * @author Evan-Ian-Ray
 */
public class LoginManagement {
    
    protected void passwordComparator(){
        String inputPassword = encryptPassword(null);
        
        
        
    }
    
    public String encryptPassword( String input_Password ) {
        
        Base64.Encoder PasswordEncoder = Base64.getEncoder();
        String outputEncryptedPassword = PasswordEncoder.encodeToString( 
            input_Password.getBytes( StandardCharsets.UTF_8 ) 
        );
        return outputEncryptedPassword;
    }
}
