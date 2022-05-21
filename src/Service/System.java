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


    public void logIn(String mail, String password) throws Exception
    {
        // Get the user that is trying to log in
        User logInTryUser = this.dbConnector.getUser(mail);

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

    public void registerFan(String name, String mail, String password, boolean isLogged, System system) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            Fan newUser = new Fan(name, mail, password, isLogged, this);
            this.dbConnector.addUser(newUser, "Fan"); // TODO - ADD the user
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerCoach(String name, String mail, String password, boolean isLogged, System system, String qualification, String position, Team team) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            Coach newUser = new Coach(name,mail,password, isLogged, system, qualification, position, team);
            this.dbConnector.addUser(newUser, "Coach");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerAssociationMember(String name, String mail, String password, boolean isLogged, System system) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            AssociationMember newUser = new AssociationMember(name, mail,password, isLogged, system);
            this.dbConnector.addUser(newUser, "AssociationMember");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerMainReferee(String name, String mail, String password, boolean isLogged, System system, String qualification, ArrayList<EventLog> eventLogs, ArrayList<Game> games, ArrayList<League> leagues) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            MainReferee newUser = new MainReferee(name, mail,password, isLogged, system, qualification, eventLogs, games, leagues);
            this.dbConnector.addUser(newUser, "MainReferee");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerReferee(String name, String mail, String password, boolean isLogged, System system, String birthDay, Position position, Team team) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            Player newUser = new Player(name, mail,password, isLogged, system, birthDay, position, team);
            this.dbConnector.addUser(newUser, "Player");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerSystemManager(String name, String mail, String password, boolean isLogged, System system) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            SystemManager newUser = new SystemManager(name, mail,password, isLogged, system);
            this.dbConnector.addUser(newUser, "SystemManager");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerTeamManager(String name, String mail, String password, boolean isLogged, System system, String[] permissions, Team team) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            TeamManager newUser = new TeamManager(name, mail,password, isLogged, system, permissions, team);
            this.dbConnector.addUser(newUser, "TeamManager");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerTeamOwner(String name, String mail, String password, boolean isLogged, System system) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbConnector.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            TeamOwner newUser = new TeamOwner(name, mail,password, isLogged, system);
            this.dbConnector.addUser(newUser, "TeamOwner");
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }
}

