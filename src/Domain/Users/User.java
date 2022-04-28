package Domain.Users;

import Service.UserApplication;
import com.sun.xml.internal.bind.v2.TODO;

public abstract class User
{

    /** -----Base attributes----- */
    private String name;
    private String userName;
    private String password;
    /** -----Derivatives attributes----- */
    private UserApplication userApplication;


    /** -----Functions----- */

    /**
     *
     * @param userName - A string representing the user name
     * @param password - A string representing the user password
     *  Logs in the user
     */
    public void login(String userName, String password)
    {
        //TODO - Implement login function + change return type
    }

    /**
     * Logs out the user
     */
    public void logOut()
    {
        //TODO - Implement logout function + change return type
    }


}
