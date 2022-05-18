package Domain;

import Service.System;

public class Guest
{
    /** -----Base attributes----- */

    /** -----Derivatives attributes----- */
    private System system;

    /** -----Functions----- */

    /**
     *
     * @param userName - A string representing the user name
     * @param password - A string representing the user password
     *  Logs in the user
     */
    public void login(String userName, String password) throws Exception
    {
        system.logIn(userName,password);
    }


    public void register(String name, String mail, String password, boolean isLogged) throws Exception
    {
        system.registerFan(name, mail, password, isLogged, system);
    }

}
