package Domain.Users;

import Service.System;

public class Fan extends User
{
    /**
     * -----Functions-----
     *
     * @param name
     * @param userName
     * @param password
     * @param isLogged
     * @param system
     */


    public Fan(String name, String userName, String password, boolean isLogged, System system)
    {
        super(name, userName, password, isLogged, system);
    }

    public Fan(String name, String userName, String password, boolean isLogged)
    {
        super(name, userName, password, isLogged);
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
