package pool.admins;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Antonio Soto
 */
public class PropertiesAdmin {

    private Properties properties;

    public PropertiesAdmin() {

        this.properties = new Properties();
    }

    protected void loadPropertiesFile(String input_PropertiesFile) {

        try {
            this.properties.load(new FileInputStream(input_PropertiesFile));
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected Properties getProperties() {

        return properties;
    }

}
