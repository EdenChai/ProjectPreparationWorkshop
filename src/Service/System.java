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

    public void registerFan(String userName, String password, boolean isLogged, System system) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(userName);
        }
        catch (UserDoesNotExist e)
        {
            if (!checkUserName(userName))
            {
                throw new UserNameInvalid("Chosen username is invalid, please use only a-z, A-Z, 0-9");

            }
            if (!checkPassword(password))
            {
                throw new PasswordTooWeak("Chosen password is too weak, please add a capital letter");
            }

            Fan newUser = new Fan(userName, password, isLogged, this);
            this.dbConnector.addUser(newUser, "Fan"); // TODO - ADD the user
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerCoach(String userName, String password, boolean isLogged, System system, String qualification, String position, Team team) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(userName);
        }
        catch (UserDoesNotExist e)
        {
            if (checkPassword(password))
            {
                throw new PasswordTooWeak("Chosen password is too weak, please add a capital letter");
            }
            Coach newUser = new Coach(userName,password, isLogged, system, qualification, position, team);
            this.dbConnector.addUser(newUser, "Coach");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerAssociationMember(String userName, String password, boolean isLogged, System system) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(userName);
        }
        catch (UserDoesNotExist e)
        {
            if (checkPassword(password))
            {
                throw new PasswordTooWeak("Chosen password is too weak, please add a capital letter");
            }
            AssociationMember newUser = new AssociationMember(userName,password, isLogged, system);
            this.dbConnector.addUser(newUser, "AssociationMember");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerMainReferee(String userName, String password, boolean isLogged, System system, String qualification, ArrayList<EventLog> eventLogs, ArrayList<Game> games, ArrayList<League> leagues) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(userName);
        }
        catch (UserDoesNotExist e)
        {
            if (checkPassword(password))
            {
                throw new PasswordTooWeak("Chosen password is too weak, please add a capital letter");
            }
            MainReferee newUser = new MainReferee(userName,password, isLogged, system, qualification, eventLogs, games, leagues);
            this.dbConnector.addUser(newUser, "MainReferee");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerReferee(String userName, String password, boolean isLogged, System system, String birthDay, Position position, Team team) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(userName);
        }
        catch (UserDoesNotExist e)
        {
            if (checkPassword(password))
            {
                throw new PasswordTooWeak("Chosen password is too weak, please add a capital letter");
            }
            Player newUser = new Player(userName,password, isLogged, system, birthDay, position, team);
            this.dbConnector.addUser(newUser, "Player");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerSystemManager(String userName, String password, boolean isLogged, System system) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(userName);
        }
        catch (UserDoesNotExist e)
        {
            if (checkPassword(password))
            {
                throw new PasswordTooWeak("Chosen password is too weak, please add a capital letter");
            }
            SystemManager newUser = new SystemManager(userName,password, isLogged, system);
            this.dbConnector.addUser(newUser, "SystemManager");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerTeamManager(String userName, String password, boolean isLogged, System system, Team team) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(userName);
        }
        catch (UserDoesNotExist e)
        {
            if (checkPassword(password))
            {
                throw new PasswordTooWeak("Chosen password is too weak, please add a capital letter");
            }
            TeamManager newUser = new TeamManager(userName,password, isLogged, system, team);
            this.dbConnector.addUser(newUser, "TeamManager");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerTeamOwner(String userName, String password, boolean isLogged, System system) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(userName);
        }
        catch (UserDoesNotExist e)
        {
            if (checkPassword(password))
            {
                throw new PasswordTooWeak("Chosen password is too weak, please add a capital letter");
            }
            TeamOwner newUser = new TeamOwner(userName,password, isLogged, system);
            this.dbConnector.addUser(newUser, "TeamOwner");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public boolean checkPassword(String password)
    {
        for (int i = 0; i < password.length(); i++)
        {
         if (!Character.isUpperCase(password.charAt(i)))
         {
             return false;
         }
        }
        return true;
    }

    public boolean checkUserName(String username)
    {
        for (int i = 0; i < username.length(); i++)
        {
            if ((username.charAt(i) < 'a' || username.charAt(i) > 'z') &&
                (username.charAt(i) < 'A' || username.charAt(i) > 'Z') &&
                (username.charAt(i) < '0' || username.charAt(i) > '9'))
            {
                return  false;
            }
        }
        return true;
    }



}

