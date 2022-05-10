package Domain.Users;

import Domain.Position;
import Domain.Team;

public class Player extends User
{
    /** -----Base attributes----- */
    private String birthDay;
    private Position position;
    /** -----Derivatives attributes----- */
    private Team team;

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
