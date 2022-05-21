package Domain.Users;

import Domain.Team;
import Service.System;

public class TeamManager extends User
{
    /** -----Base attributes----- */
    /** -----Derivatives attributes----- */
    private Team team;

    public TeamManager(String userName, String password, boolean isLogged, System system, Team team)
    {
        super(userName, password, isLogged, system);
        this.team = team;
    }

    public TeamManager(String userName, String password, boolean isLogged, Team team)
    {
        super(userName, password, isLogged);
        this.team = team;
    }


    /** -----Functions----- */

}
