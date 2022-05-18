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

    public Coach(String name, String userName, String password, boolean isLogged, System system, String qualification, String position, Team team)
    {
        super(name, userName, password, isLogged, system);
        this.qualification = qualification;
        this.position = position;
        this.team = team;
    }

    public Coach(String name, String userName, String password, boolean isLogged, String qualification, String position, Team team)
    {
        super(name, userName, password, isLogged);
        this.qualification = qualification;
        this.position = position;
        this.team = team;
    }


    /** -----Functions----- */

    /**
     *
     * @param field - A string representing which field to update
     * @param text - A string representing to what update the field to
     */
    public void updateDetails(String field, String text)
    {
        //TODO - Implement updateDetails function + change return type
    }

}
