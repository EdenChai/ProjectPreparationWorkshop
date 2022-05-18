package Domain.Users;

import Domain.Team;
import Service.System;

public class TeamManager extends User
{
    /** -----Base attributes----- */
    private String[] permissions;
    /** -----Derivatives attributes----- */
    private Team team;

    public TeamManager(String name, String userName, String password, boolean isLogged, System system, String[] permissions, Team team)
    {
        super(name, userName, password, isLogged, system);
        this.permissions = permissions;
        this.team = team;
    }

    public TeamManager(String name, String userName, String password, boolean isLogged, String[] permissions, Team team)
    {
        super(name, userName, password, isLogged);
        this.permissions = permissions;
        this.team = team;
    }


    /** -----Functions----- */


    /**
     * Activates the manage abilities based on avillable permissions
     */
    public void manage()
    {
        //TODO - Implement this function + change return type
    }
}
