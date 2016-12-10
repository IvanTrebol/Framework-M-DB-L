package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionForDatabase {

    private Connection ConnectionToDataBase;
    private String DRIVER;
    private String HOST;
    private String USER;
    private String PASSWORD;

    public ConnectionForDatabase(String URL) throws FileNotFoundException, IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream(URL));

        this.DRIVER = properties.getProperty("DRIVER");
        this.HOST = properties.getProperty("HOST");
        this.USER = properties.getProperty("USER");
        this.PASSWORD = properties.getProperty("PASSWORD");
    }

    public String getDRIVER() {
        return DRIVER;
    }

    public String getHOST() {
        return HOST;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

}
