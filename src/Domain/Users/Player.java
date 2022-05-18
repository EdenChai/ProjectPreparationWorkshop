package Domain.Users;

import Domain.Position;
import Domain.Team;
import Service.System;

public class Player extends User
{
    /** -----Base attributes----- */
    private String birthDay;
    private Position position;
    /** -----Derivatives attributes----- */
    private Team team;

    public Player(String name, String userName, String password, boolean isLogged, System system, String birthDay, Position position, Team team)
    {
        super(name, userName, password, isLogged, system);
        this.birthDay = birthDay;
        this.position = position;
        this.team = team;
    }

    public Player(String name, String userName, String password, boolean isLogged, String birthDay, Position position)
    {
        super(name, userName, password, isLogged);
        this.birthDay = birthDay;
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
        switch(field)
        {
            case "userName":
                setUserName(text);
                break;
            case "password":
                setPassword(text);
                break;
            case "birthDay":
                setBirthDay(text);
                break;
            default:
        }
    }

    public void updateDetails(String field, Position position)
    {
       setPosition(position);
    }

    public void updateDetails(String field, Team team)
    {
       setTeam(team);
    }

    public String getBirthDay()
    {
        return birthDay;
    }

    public void setBirthDay(String birthDay)
    {
        this.birthDay = birthDay;
    }

    public Position getPosition()
    {
        return position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public Team getTeam()
    {
        return team;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }



}
