package mapping;


import java.lang.reflect.Field;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gerry
 */
public abstract class AbstractDatabaseHandler<T>{
    
    //Crea un controlador abstracto que será usado en las clases para
    //insertar y seleccionar
    
    protected Class<T> type;
    
    //"Instancia" de interfaz
    protected DatabaseConnecter dbConnecter;
    
    protected final String query;
    
    protected AbstractDatabaseHandler(Class<T> type,
            DatabaseConnecter dbConnecter){
        
        this.dbConnecter = dbConnecter;
        this.type = type;
        this.query = createQuery();
        
    }
    
    protected abstract String createQuery();
    
    //Recibe los nombres de las columnas
    protected String getColumns(boolean usePlaceHolders){
        StringBuilder sb = new StringBuilder();
        
        boolean first = true;
        
        for(Field f : type.getDeclaredFields()){
            if(first)
                first = false;
            else
                sb.append(", ");
            
            if(usePlaceHolders)
                sb.append("?");
            else
                sb.append(f.getName());
            
        }
        
        return sb.toString();
        
    }
    
    
    
}
