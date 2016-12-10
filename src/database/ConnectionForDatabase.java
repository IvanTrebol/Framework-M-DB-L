
package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionForDatabase {

    private Connection ConnectionToDataBase;
    private String DRIVER;
    private String HOST;
    private String USER;
    private String PASSWORD;

    public ConnectionForDatabase(String URL) throws FileNotFoundException, IOException {
        
        try {
            
            Properties properties = new Properties();
            properties.load(new FileInputStream(URL) );
            
            this.DRIVER = properties.getProperty("DRIVER");
            this.HOST = properties.getProperty("HOST");
            this.USER = properties.getProperty("USER");
            this.PASSWORD = properties.getProperty("PASSWORD");
            Class.forName(this.DRIVER);
            ConnectionToDataBase = DriverManager.getConnection(this.HOST, this.USER, this.PASSWORD);
            System.out.println("WE DID IT");
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return ConnectionToDataBase;
    }

    public void closeConnection() {
        try {
            ConnectionToDataBase.close();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }
    
}