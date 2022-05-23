package Domain.Users;

import Service.System;

public abstract class User
{

    private String userName;
    private String password;
    private boolean isLogged;
    /** -----Derivatives attributes----- */
    private static System system;

/** -----Functions----- */

    public User(String userName, String password, boolean isLogged)
    {
        this.userName = userName;
        this.password = password;
        this.isLogged = isLogged;
    }

    public static void logIn(String userName, String password) throws Exception
    {
        system.logIn(userName,password);

    }

//    /**
//     * Logs out the user
//     */
//    public void logOut()
//    {
//        //TODO - Implement logout function + change return type
//    }


    /** -----Getters and Setters----- */

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public System getSystem()
    {
        return system;
    }

    public void setSystem(System system)
    {
        this.system = system;
    }

    public boolean isLogged()
    {
        return isLogged;
    }

    public void setLogged(boolean logged)
    {
        isLogged = logged;
    }

}
