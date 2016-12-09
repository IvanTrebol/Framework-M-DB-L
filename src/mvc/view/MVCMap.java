/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author Jorge A. Cano
 */
@XmlRootElement(name = "MVCMap")
public class MVCMap {

    @XmlElement(name = "controller")
    private List<ControllerInterface> controllers;

    public List<ControllerInterface> getControllers() {
        return controllers;
    }

    
    public static class ControllerInterface {

        @XmlAttribute
        private String id;

        @XmlAttribute
        private String classname;

        @XmlElement(name = "service")
        private List<Service> services;

        public String getId() {
            return id;
        }

        public String getClassname() {
            return classname;
        }

        public List<Service> getServices() {
            return services;
        }
        
        
        public static class Service {
            
            @XmlAttribute
            private String id;
            
            @XmlValue
            private String methodname;

            public String getId() {
                return id;
            }

            public String getMethodname() {
                return methodname;
            }
            
        }
    }

}
