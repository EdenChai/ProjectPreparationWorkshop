package Service;

import DataAccess.DBConnector;
import Domain.*;
import Domain.Users.*;
import Exceptions.UserAlreadyExist;
import Exceptions.UserDoesNotExist;
import Exceptions.UserIsAlreadyLoggedIn;
import Exceptions.UserPasswordDoesNotMatch;

import java.util.*;

public class System
{
    public System(DBConnector dbConnector)
    {
        this.dbConnector = dbConnector;
    }

    /** -----User log in scenario----- */

    private DBConnector dbConnector;


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
            TeamOwner newUser = new TeamOwner(userName,password, isLogged, system);
            this.dbConnector.addUser(newUser, "TeamOwner");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }
}

