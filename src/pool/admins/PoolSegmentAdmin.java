package pool.admins;

import database.ConnectionForDatabase;
import pool.exceptions.ConnectionPoolException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.sql.DataSource;
import mapping.DatabaseConnecter;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 *
 * @author Antonio Soto
 */
public class PoolSegmentAdmin implements DatabaseConnecter{
    
    private ArrayList<BasicDataSource> poolSegments = new ArrayList();
    private Properties poolProperties = new Properties();
    private ConnectionForDatabase dbConnector;
    
    public PoolSegmentAdmin( String poolFile, ConnectionForDatabase dbConnector ) throws ConnectionPoolException{
        
        try {
            this.poolProperties.load(new FileInputStream( poolFile ) );
            this.dbConnector = dbConnector;
            
        } catch (IOException ex) {
            throw new ConnectionPoolException("Error en la lectura de los archivos de Propiedades.");
        }
    }
    
    // Añade un segmento a la lista de pools.
    public void addSegment() throws Exception{
        
        BasicDataSource dataSource = BasicDataSourceFactory.createDataSource( this.poolProperties );
        
        dataSource.setDriverClassName( this.dbConnector.getDRIVER() );
        dataSource.setUrl( this.dbConnector.getHOST() );
        dataSource.setUsername( this.dbConnector.getUSER() );
        dataSource.setPassword( this.dbConnector.getPASSWORD() );
        
        dataSource.setMinIdle( Integer.parseInt( this.poolProperties.getProperty("min") ) );
        dataSource.setMaxIdle( Integer.parseInt( this.poolProperties.getProperty("max") ) );
        dataSource.setMaxOpenPreparedStatements( Integer.parseInt( this.poolProperties.getProperty("statements") ) );
        
        this.poolSegments.add( dataSource );
    }
    
    // Remueve un segmento de pool de la lista de pools.
    public void removeSegment( int segment ) throws ConnectionPoolException{
        
        BasicDataSource poolToRemove = this.poolSegments.get( segment );
        
        if( this.poolSegments.contains( poolToRemove )  ){
            this.poolSegments.remove( poolToRemove );
        }
        else{
            throw new ConnectionPoolException("No existe ese elemento a remover.");
        }   
    }
    
    // Provee las conexiones.
    public Connection getConnection( int segment ) throws SQLException{
        
        return this.poolSegments.get( segment ).getConnection();
    }
    
    // Cierra la conexión.
    public void closeConnection( int segment ) throws SQLException{
        
        this.poolSegments.get( segment ).close();
    }
    
    // Asigna el número mínimo de conexiones.
    public void setMinConnections( int segment, int minIdle ){
        
        this.poolSegments.get( segment ).setMinIdle( minIdle );
    }
    
    // Asigna el número máximo de conexiones.
    public void setMaxConnections( int segment, int maxIdle ){
        
        this.poolSegments.get( segment ).setMaxIdle( maxIdle );
    }
    
    // Asigna el número máximo de PreparedStatements.
    public void setMaxOpenPreparedStatements( int segment, int maxOpenStatements ){
        
        this.poolSegments.get( segment ).setMaxOpenPreparedStatements( maxOpenStatements );
    }
    
    // Incrementa el tamaño del Pool.
    public void increasePool( int segment, int increaseValue ){
        
        int maxConnections = this.getMaxConnections(segment);
        
        this.poolSegments.get( segment ).setMaxIdle( maxConnections + increaseValue );
    }
    
    // Decrementa el tamaño del Pool.
    public void decreasePool( int segment, int decreaseValue ) throws ConnectionPoolException{
        
        int maxConnections = this.getMaxConnections(segment);
        
        if( maxConnections > decreaseValue ){
            this.poolSegments.get( segment ).setMaxIdle( maxConnections - decreaseValue );
            
        }
        else{
            throw new ConnectionPoolException("No puedes decrementar esa cantidad.");
        }
    }
    
    // Devuelve el número máximo de Conexiones.
    public int getMaxConnections( int segment ){
        
        return this.poolSegments.get( segment ).getMaxIdle();
    }

    public DataSource getPoolSegment( int segment ) {
        
        return poolSegments.get( segment );
    }

    @Override
    public Connection createConnection() throws SQLException {
        return this.getConnection(0); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getConnectionUrl() {
        return dbConnector.getURL(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
