package Service;

import DataAccess.UserDao;
import Domain.*;

import java.sql.SQLException;
import java.util.*;

public class UserApplication {
    UserController uc = new UserController();

    public void insertUser(String iName, String iEmail) {
        uc.insertUser(iName, iEmail);
    }


    //~~~~~~~~~~~~~SWITCH:~~~~~~~~~~~~~
    boolean flag = true;
            while(flag)

    {
        try {
            String menu = "\nWelcome to ePark!\n1.Register guardian\n2.Log in\n3.Register additional child\n4.Mange Ticket(add or remove)\n5.Add ride\n6.exit park \n7.exit";
            System.out.println(menu);
            Scanner scan = new Scanner(System.in);
            String number = scan.next();
            switch (number) {
                case "1"://Register guardian
                    break;

                case "2"://Login
                    break;

                case "3": //Register additional child
                    break;

                case "4"://Mange Ticket
                    break;

                case "5"://add ride
                    break;

                case "6"://exit park
                    break;

                case "7"://exit

                case "Exit":

                default:
                    System.out.println("Please try again");

            }
        } catch (Exception e) {
            System.out.println("Error occurred, please try again ");
        }
    }
}

