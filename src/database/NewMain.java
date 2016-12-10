
package Database;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NewMain {

   
    public static void main(String[] args) {
        String url = "F:/Arquitectura de Soft/DataBaseConnection/src/properties";
        ConnectionForDatabase connection;
        try {
            connection = new ConnectionForDatabase(url);
        } catch (IOException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
