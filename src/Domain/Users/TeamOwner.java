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


//    /** -----Functions attributes----- */
//
//    /**
//     * Makes the target user the owner of the current team in addition
//     * @param user - A User object representing the user
//     */
//    public void addOwner(User user)
//    {
//        //
//    }
//
//    /**
//     * Removes the manage/owner status from targeted user
//     * @param user - A User object representing the user
//     */
//    public void removeAppointed(User user)
//    {
//        //
//    }
//
//    /**
//     * Makes the target user the manager of the current team in addition
//     * @param user - A User object representing the user
//     */
//    public void addManager(User user)
//    {
//        //
//    }
//
//    /**
//     * Selects which permissions the targeted user Manager has
//     * @param user - A User object representing the user
//     */
//    public void managePermissions(User user)
//    {
//        //
//    }
//
//    /**
//     * Disbands the current team
//     * @param team - A Team object representing the current team
//     */
//    public void closeTeam(Team team)
//    {
//        //
//    }
}
