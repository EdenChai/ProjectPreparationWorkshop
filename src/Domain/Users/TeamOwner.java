package Domain.Users;

import Domain.Team;
import Service.System;

public class TeamOwner extends User
{
    /** -----Base attributes----- */
    private User[] appointed;
    /** -----Derivatives attributes----- */
    private Team team;

    public TeamOwner(String userName, String password, boolean isLogged)
    {
        super(userName, password, isLogged);
    }

}
