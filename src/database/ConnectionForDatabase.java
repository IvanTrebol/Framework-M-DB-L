
package database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionForDatabase {

    protected String DRIVER;
    protected String HOST;
    protected String USER;
    protected String PASSWORD;
    private String URL;

    public ConnectionForDatabase(String URL) throws FileNotFoundException, IOException {
        
        this.URL = URL;
        Properties properties = new Properties();
        properties.load(new FileInputStream(URL) );
        this.DRIVER = properties.getProperty("DRIVER");
        this.HOST = properties.getProperty("HOST");
        this.USER = properties.getProperty("USER");
        this.PASSWORD = properties.getProperty("PASSWORD");
    }
    
    public String getURL(){
        return this.URL;
    }

    /**
     * @return the DRIVER
     */
    public String getDRIVER() {
        return DRIVER;
    }

    /**
     * @return the HOST
     */
    public String getHOST() {
        return HOST;
    }

    /**
     * @return the USER
     */
    public String getUSER() {
        return USER;
    }

    /**
     * @return the PASSWORD
     */
    public String getPASSWORD() {
        return PASSWORD;
    }
    
    
    
}
