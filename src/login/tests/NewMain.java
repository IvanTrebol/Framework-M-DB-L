/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.tests;

import login.security.ListOfUserLevels;

/**
 *
 * @author Evan-Ian-Ray
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        ListOfUserLevels loul = new ListOfUserLevels();
//        
//        loul.addNewUserLevel("profesor", 5);
//        loul.addNewUserLevel("tu mamá", 5);
//        loul.addNewUserLevel("tu hermana", 5);
        

char[] result = "Stack Me 123 Heppa1 oeu".replaceAll("[^0-9]","").toCharArray();
System.out.println(java.util.Arrays.toString(result));


        
    }
    
}
