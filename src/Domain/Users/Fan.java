package Domain.Users;

import Service.System;

public class Fan extends User
{
    /**
     * -----Functions-----
     *
     * @param userName
     * @param password
     * @param isLogged
     * @param system
     */


    public Fan(String userName, String password, boolean isLogged, System system)
    {
        super(userName, password, isLogged, system);
    }

    public Fan(String userName, String password, boolean isLogged)
    {
        super(userName, password, isLogged);
    }

    /** -----Functions----- */


    /**
     *
     * @param field - A string representing which field to update
     * @param text - A string representing to what update the field to
     */
    public void updateDetails(String field, String text)
    {
        switch(field)
        {
            case "userName":
                setUserName(text);
                break;
            case "password":
                setPassword(text);
                break;
            default:
        }
    }

}
