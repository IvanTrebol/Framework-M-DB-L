/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.security;

import login.security.UsersLogInTriesByLevels;

/**
 *  In this class is defined the levels a new user
 *  can be placed at the time of their registration
 * 
 * @author Evan-Ian-Ray
 */
public class UserLevels {
    
    UsersLogInTriesByLevels maximumNumberOfTries = new UsersLogInTriesByLevels();

    
    public void userLevel(){
        maximumNumberOfTries.getUserMaximumLogInTries();
    }
    
    
    public void rootLevel(){
        maximumNumberOfTries.getRootMaximumLogInTries();
    }
}
