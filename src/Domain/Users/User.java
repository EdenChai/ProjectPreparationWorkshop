package Domain.Users;

import Service.System;

public abstract class User
{

    /** -----Base attributes----- */
    private String userName;
    private String password;
    private boolean isLogged;
    /** -----Derivatives attributes----- */



    public User( String userName, String password, boolean isLogged)
    {
        this.userName = userName;
        this.password = password;
        this.isLogged = isLogged;
    }

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

    public boolean isLogged()
    {
        return isLogged;
    }

    public void setLogged(boolean logged)
    {
        isLogged = logged;
    }

}
