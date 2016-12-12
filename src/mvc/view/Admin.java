/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.view.MVCMap.ControllerInterface;
import mvc.view.MVCMap.ControllerInterface.Service;
import mvc.controller.Controller;
import mvc.exceptions.MVCException;

/**
 *
 * @author a14016339
 */
public class Admin {

    private static final Admin controllerAdmin = new Admin();

    private MVCMap MVCcontext;

    private Admin() {
        ;
    }

    public static Admin getAdmin() {
        return controllerAdmin;
    }

    public void setMVCcontext(MVCMap MVCcontext) {
        this.MVCcontext = MVCcontext;
    }

    Object requestService(String controllerID, String serviceID, HashMap parameters) throws MVCException {

        ControllerInterface controllerInterface = null;
        String methodName = null;

        if (this.MVCcontext == null) {
            throw new MVCException( "The configuration file has not been loaded into the Admin" );
        }
        
        try {

            controllerInterface = searchForController(controllerID);
            methodName = searchForMethod(controllerInterface, serviceID);

            Class controllerClass = Class.forName(controllerInterface.getClassname());
            Controller controller = (Controller) controllerClass.newInstance();

            Method method = controllerClass.getDeclaredMethod(methodName, HashMap.class);

            return method.invoke(controller, parameters);

        } catch (ClassNotFoundException ex) {
            throw new MVCException( "No such class with name: " + controllerInterface.getClassname() );

        } catch (IllegalAccessException ex) {
            throw new MVCException( "The class or method is not public" );

        } catch (IllegalArgumentException ex) {
            throw new MVCException( "The provided parameter is not a HashMap" );

        } catch (InvocationTargetException ex) {
            ex.getCause().printStackTrace();

        } catch (NoSuchMethodException ex) {
            throw new MVCException( "There is no method called " + methodName + " in class " + controllerInterface.getClassname() );

        } catch (SecurityException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            throw new MVCException( "The class " + controllerInterface.getClassname() + " cannot be instantiated" );

        } catch (ClassCastException ex) {
            throw new MVCException( "The class " + controllerInterface.getClassname() + " is not a controller class" );

        }

        return null;
    }

    private ControllerInterface searchForController(String controllerID) throws MVCException {

        Iterator controllersIterator = this.MVCcontext.getControllers().iterator();
        boolean isControllerFound = false;
        ControllerInterface controllerInterface = null;

        while (controllersIterator.hasNext() && !isControllerFound) {

            controllerInterface = (ControllerInterface) controllersIterator.next();
            isControllerFound = controllerInterface.getId().equals(controllerID);
        }

        if (!isControllerFound) {
            throw new MVCException("There is no such controller with id " + controllerID);
        }

        return controllerInterface;
    }

    private String searchForMethod(ControllerInterface controllerInterface, String serviceID) throws MVCException {

        Iterator servicesIterator = controllerInterface.getServices().iterator();
        boolean isServiceFound = false;
        Service service = null;

        while (servicesIterator.hasNext() && !isServiceFound) {

            service = (Service) servicesIterator.next();
            isServiceFound = service.getId().equals(serviceID);
        }

        if (!isServiceFound) {
            throw new MVCException("There is no such method with id " + serviceID
                    + " in class " + controllerInterface.getClassname());
        }

        return service.getMethodname();
    }
}
