package Domain.Users;

import Domain.Team;
import Service.System;

public class SystemManager extends User
{
    /** -----Derivatives attributes----- */
    private System system;

    public SystemManager(String name, String userName, String password, boolean isLogged, System system)
    {
        super(name, userName, password, isLogged, system);
        this.system = system;
    }

    public SystemManager(String name, String userName, String password, boolean isLogged)
    {
        super(name, userName, password, isLogged);
    }


    /** -----Functions----- */

    /**
     * Disbands the targeted team
     * @param team - A Team object representing the team
     */
    public void closeTeam(Team team)
    {
        //TODO - Implement this function + change return type
    }

    /**
     * Removes the targeted user from the system
     * @param user - A user object representing the user to remove
     */
    public void removeUser(User user)
    {
        //TODO - Implement this function + change return type
    }

    /**
     * Shows the system manager all the system logs
     */
    public void showSystemLog()
    {
        //TODO - Implement this function + change return type
    }
}
