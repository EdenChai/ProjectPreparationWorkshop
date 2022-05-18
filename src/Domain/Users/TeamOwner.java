package Domain.Users;

import Domain.Team;
import Service.System;

public class TeamOwner extends User
{
    /** -----Base attributes----- */
    private User[] appointed;
    /** -----Derivatives attributes----- */
    private Team team;


    public TeamOwner(String name, String userName, String password, boolean isLogged, System system)
    {
        super(name, userName, password, isLogged, system);
    }

    public TeamOwner(String name, String userName, String password, boolean isLogged)
    {
        super(name, userName, password, isLogged);
    }


    /** -----Functions attributes----- */

    /**
     * Makes the target user the owner of the current team in addition
     * @param user - A User object representing the user
     */
    public void addOwner(User user)
    {
        //TODO - Implement this function + change return type
    }

    /**
     * Removes the manage/owner status from targeted user
     * @param user - A User object representing the user
     */
    public void removeAppointed(User user)
    {
        //TODO - Implement this function + change return type
    }

    /**
     * Makes the target user the manager of the current team in addition
     * @param user - A User object representing the user
     */
    public void addManager(User user)
    {
        //TODO - Implement this function + change return type
    }

    /**
     * Selects which permissions the targeted user Manager has
     * @param user - A User object representing the user
     */
    public void managePermissions(User user)
    {
        //TODO - Implement this function + change return type
    }

    /**
     * Disbands the current team
     * @param team - A Team object representing the current team
     */
    public void closeTeam(Team team)
    {
        //TODO - Implement this function + change return type
    }
}
