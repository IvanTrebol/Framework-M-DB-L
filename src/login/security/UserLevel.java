package login.security;

/**
 *  In this class you define a new level given a String, the name of the new
 *  User Level, and an Integer, the number of login tries that level has
 * 
 * @author Evan-Ian-Ray
 */

public class UserLevel {
  
    private String levelName;
    private int loginTries;
    
    public UserLevel( String input_levelName ,int input_logInTries ){
         
        this.levelName = input_levelName;
        this.loginTries = input_logInTries;
    
    }

    /**
     * @return the levelName
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * @param levelName the levelName to set
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    
    /**
     * @return the loginTries
     */
    public int getLoginTries(){
        
        return loginTries;
    }

    /**
     * @param loginTries the loginTries to set
     */
    public void setLoginTries(int loginTries) {
        this.loginTries = loginTries;
    }

}