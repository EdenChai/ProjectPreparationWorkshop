package Service;

import DataAccess.DBController;
import DataAccess.UserDao;
import Domain.*;
import Domain.Users.*;
import Exceptions.UserAlreadyExist;
import Exceptions.UserDoesNotExist;
import Exceptions.UserIsAlreadyLoggedIn;
import Exceptions.UserPasswordDoesNotMatch;

import java.sql.SQLException;
import java.util.*;

public class System
{
    public System(DBController dbController)
    {
        this.dbController = dbController;
    }

    /** -----User log in scenario----- */

    private DBController dbController;


    public void logIn(String mail, String password) throws Exception
    {
        // Get the user that is trying to log in
        User logInTryUser = this.dbController.getUser(mail);

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
            logInTryUser = this.dbController.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            Fan newUser = new Fan(name, mail, password, isLogged, this);
            this.dbController.addUser(newUser); // TODO - ADD the user
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerCoach(String name, String mail, String password, boolean isLogged, System system, String qualification, String position, Team team) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbController.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            Coach newUser = new Coach(name,mail,password, isLogged, system, qualification, position, team);
            this.dbController.addCoach(newUser);
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerAssociationMember(String name, String mail, String password, boolean isLogged, System system) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbController.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            AssociationMember newUser = new AssociationMember(name, mail,password, isLogged, system);
            this.dbController.addAssociationMember(newUser);
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerMainReferee(String name, String mail, String password, boolean isLogged, System system, String qualification, ArrayList<EventLog> eventLogs, ArrayList<Game> games, ArrayList<League> leagues) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbController.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            MainReferee newUser = new MainReferee(name, mail,password, isLogged, system, qualification, eventLogs, games, leagues);
            this.dbController.addMainReferee(newUser);
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerReferee(String name, String mail, String password, boolean isLogged, System system, String birthDay, Position position, Team team) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbController.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            Player newUser = new Player(name, mail,password, isLogged, system, birthDay, position, team);
            this.dbController.addPlayer(newUser);
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerSystemManager(String name, String mail, String password, boolean isLogged, System system) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbController.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            SystemManager newUser = new SystemManager(name, mail,password, isLogged, system);
            this.dbController.addSystemManager(newUser);
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerTeamManager(String name, String mail, String password, boolean isLogged, System system, String[] permissions, Team team) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbController.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            TeamManager newUser = new TeamManager(name, mail,password, isLogged, system, permissions, team);
            this.dbController.addTeamManager(newUser);
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }

    public void registerTeamOwner(String name, String mail, String password, boolean isLogged, System system) throws Exception
    {
        User logInTryUser = null;
        try
        {
            logInTryUser = this.dbController.getUser(mail);
        }
        catch (UserDoesNotExist e)
        {
            TeamOwner newUser = new TeamOwner(name, mail,password, isLogged, system);
            this.dbController.addTeamOwner(newUser);
            return;
        }
        throw new UserAlreadyExist("User already exist! Please pick a different user name.");
    }







//    //~~~~~~~~~~~~~SWITCH:~~~~~~~~~~~~~
//    boolean flag = true;
//            while(flag)
//
//    {
//        try {
//            String menu = "\nWelcome to ePark!\n1.Register guardian\n2.Log in\n3.Register additional child\n4.Mange Ticket(add or remove)\n5.Add ride\n6.exit park \n7.exit";
//            java.lang.System.out.println(menu);
//            Scanner scan = new Scanner(java.lang.System.in);
//            String number = scan.next();
//            switch (number) {
//                case "1"://Register guardian
//                    break;
//
//                case "2"://Login
//                    break;
//
//                case "3": //Register additional child
//                    break;
//
//                case "4"://Mange Ticket
//                    break;
//
//                case "5"://add ride
//                    break;
//
//                case "6"://exit park
//                    break;
//
//                case "7"://exit
//
//                case "Exit":
//
//                default:
//                    java.lang.System.out.println("Please try again");
//
//            }
//        } catch (Exception e) {
//            java.lang.System.out.println("Error occurred, please try again ");
//        }
//    }
}

