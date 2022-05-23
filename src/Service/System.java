package Service;

import DataAccess.DBConnector;
import Domain.*;
import Domain.Users.*;
import Exceptions.*;

import java.util.*;

public class System
{
    public System(DBConnector dbConnector)
    {
        this.dbConnector = dbConnector;
    }

    /** -----User log in scenario----- */

    private DBConnector dbConnector;



    public void assignGamesRandomly(ArrayList<Game> games, User user) throws Exception {
        if(!(user instanceof AssociationMember)){
            //TODO exception
        }
        if(!user.isLogged()){
            throw new UserIsNotLoggedIn("User is not logged in");
        }
        ((AssociationMember)user).assignGamesRandomly(games);
        //TODO check if the user that is logged in is association member + call the assosciation member function
    }

    public void assignGamesByIndex(ArrayList<Game> games,User user) throws Exception {
        if(!(user instanceof AssociationMember)){
            //TODO exception
        }
        if(!user.isLogged()){
            throw new UserIsNotLoggedIn("User is not logged in");
        }
        ((AssociationMember)user).assignGamesByIndex(games);
        ;
    }

    public void assignRefereesRandomly(ArrayList<Game> games,User user) throws Exception {
        if(!(user instanceof AssociationMember)){
            //TODO exception
        }
        if(!user.isLogged()){
            throw new UserIsNotLoggedIn("User is not logged in");
        }
        ((AssociationMember)user).assignRefereesRandomly(games);
    }

    public void assignRefereesByIndex(ArrayList<Game> games, User user) throws Exception {
        if(!(user instanceof AssociationMember)){
            //TODO exception
        }
        if(!user.isLogged()){
            throw new UserIsNotLoggedIn("User is not logged in");
        }
        ((AssociationMember)user).assignRefereesByIndex(games);    }

    /**
     *  Logs in the user
      * @param userName - String representing user name
     * @param password -  String representing user password
     * @throws Exception - user already logged it, password don't match
     */
    public void logIn(String userName, String password) throws Exception
    {
        // Get the user that is trying to log in
        User logInTryUser = this.dbConnector.getUser(userName);

        // If the User is already logged in
        if (logInTryUser.isLogged())
        {
            throw new UserIsAlreadyLoggedIn("User already logged in, please log out first");
        }

        // If passwords don't match
        if (!logInTryUser.getPassword().equals(password))
        {
            throw new UserPasswordDoesNotMatch("Passwords do not match, please try again");
        }

        //If user exist and password match, log him in
        logInTryUser.setLogged(true);
        //this.dbController.updateUser(); TODO- update the user
    }

}

