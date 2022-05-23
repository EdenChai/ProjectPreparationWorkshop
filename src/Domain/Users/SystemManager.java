package Domain.Users;

import Domain.Team;
import Service.System;

public class SystemManager extends User
{
    /** -----Derivatives attributes----- */
    private System system;


    public SystemManager(String userName, String password, boolean isLogged)
    {
        super(userName, password, isLogged);
    }


}
