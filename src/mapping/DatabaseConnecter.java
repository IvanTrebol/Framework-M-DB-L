package mapping;


import java.sql.Connection;
import java.sql.SQLException;

/* Esta interface proporciona métodos que serán usados por las clases
    DatabaseInserter y DatabaseSelecter
*/

public interface DatabaseConnecter {
    
    
    //Método de delegación, sólo necesita devolver una conexión
    public Connection createConnection() throws SQLException;

/**
* Returns the connection url
*
* @return
*/  
    //Devuelve la URL
    public String getConnectionUrl();
} 