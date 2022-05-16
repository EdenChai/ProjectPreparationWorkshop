package Service;

import DataAccess.DBController;
import Domain.*;
import Domain.Users.User;

public class System
{
    UserController uc = new UserController();

    public void insertUser(String iName, String iEmail) {
        uc.insertUser(iName, iEmail);
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
            throw new Exception("User already logged in, please log out first");
        }

        // If passwords don't match
        if (!logInTryUser.getPassword().equals(password))
        {
            throw new Exception("Passwords do not match, please try again");
        }

        //If user exist and password match, log him in
        logInTryUser.setLogged(true);
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

