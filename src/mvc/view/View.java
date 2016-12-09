/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.util.HashMap;
import mvc.exceptions.MVCException;

/**
 *
 * @author a14016339
 */
public class View {

    public Object callService(
            String controllerName,
            String serviceName,
            HashMap parameters
    ) throws MVCException {

        return Admin.getAdmin().requestService(controllerName, serviceName, parameters);
    }
}
