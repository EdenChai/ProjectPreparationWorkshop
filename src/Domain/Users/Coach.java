package Domain.Users;

import Domain.Team;
import Service.System;

public class Coach extends User
{
    /** -----Base attributes----- */
    private String qualification;
    private String position;
    /** -----Derivatives attributes----- */
    private Team team;


    public Coach(String userName, String password, boolean isLogged, String qualification, String position, Team team)
    {
        super(userName, password, isLogged);
        this.qualification = qualification;
        this.position = position;
        this.team = team;
    }




}
