/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.security;

/**
 *
 * @author Evan-Ian-Ray
 */
public class UsersLogInTriesByLevels {
    
    private int maximumUserLogInTries;
    private int maximumRootLogInTries;
    
    public int getUserMaximumLogInTries(){
      
        return maximumUserLogInTries;
    }
    
    public void setUserMaximumLogInTries( int input_tries ){
        
        this.maximumUserLogInTries = input_tries;
    }
    
    
    public int getRootMaximumLogInTries(){
        
        return maximumRootLogInTries;
    }
    
    public void setRootMaximumLogInTries( int input_tries ){
        
        this.maximumRootLogInTries = input_tries;
    }
}
