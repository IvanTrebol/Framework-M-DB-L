/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import mapping.exceptions.ListEmptyException;
import mapping.exceptions.TableEmptyException;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerry
 */
public class DBMap {
    private DatabaseSelecter dbSelecter;
    private DatabaseInserter dbInserter;

    public DBMap(DatabaseConnecter connecter, String className) {
        try {
            this.dbSelecter = new DatabaseSelecter(Class.forName(className), connecter );
            this.dbInserter = new DatabaseInserter(Class.forName(className), connecter );
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
    }
    
    public List retrieveObjectsList(){
        List objectList = null;
        try {
            objectList = dbSelecter.selectObjects();
            if(objectList == null){
                throw new TableEmptyException("Table has no elements.");
            }
        } catch (TableEmptyException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally{
            return objectList;
        }
    }
    
    public void insertObjects(List list){
        List objectsList = list;
        try {
            if(objectsList == null) throw new ListEmptyException("Your list is empty.");
            dbInserter.insertObjects(objectsList);
        } catch (ListEmptyException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (SQLException ex) {
            Logger.getLogger(DBMap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(DBMap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DBMap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DBMap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBMap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IntrospectionException ex) {
            Logger.getLogger(DBMap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DBMap.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    
}
