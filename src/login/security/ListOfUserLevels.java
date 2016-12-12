package login.security;

import java.util.ArrayList;

/**
 *
 * @author Evan-Ian-Ray
 */
public class ListOfUserLevels {
    
    ArrayList<UserLevel> levelsList = new ArrayList<>();
    
    
    public ListOfUserLevels(){}
    
    
    public void addNewUserLevel( String input_levelName ,int input_logInTries ){

        UserLevel newUserLevel = new UserLevel(input_levelName, input_logInTries);
        levelsList.add( newUserLevel );
    }
    
    public UserLevel getUserLevel( int input_positionInList ){

        return levelsList.get( input_positionInList );
    }
}
