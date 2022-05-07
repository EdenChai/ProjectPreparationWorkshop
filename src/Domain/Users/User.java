package Domain.Users;

import Service.System;

public abstract class User
{

    /** -----Base attributes----- */
    private String name;
    private String userName;
    private String password;
    private boolean isLogged;
    /** -----Derivatives attributes----- */
    private System system;


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


    /** -----Getters and Setters----- */

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

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
