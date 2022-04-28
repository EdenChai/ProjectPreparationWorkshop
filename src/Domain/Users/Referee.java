package Domain.Users;

public class Referee extends User
{
    /** -----Base attributes----- */
    private String qualification;
    /** -----Derivatives attributes----- */
    private EventLog[] eventLogs;
    private Game[] games;
    private League[] leagues;

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

    /**
     *
     * @param game - A Game object that is representing a game
     * Creates a new Event object and adds it to the game event log
     */
    public void addEvent(Game game)
    {
        //TODO - Implement addEvent function + change return type
    }

    /**
     *
     * @param game - A Game object that is representing a game
     * Edits final events in the report and makes one to be added to the event report logs
     */
    public void editEventReport(Game game)
    {
        //TODO - Implement editEventReport function + change return type
    }

    /**
     *
     * @param game - A Game object that is representing a game
     * @param score - A string representing the game's score results
     * Sets the resulting score of a game to the given score
     */
    public addResult(Game game, String score)
    {
        //TODO - Implement addResult function + change return type
    }

}
