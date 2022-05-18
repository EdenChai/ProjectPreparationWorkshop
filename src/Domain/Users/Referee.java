package Domain.Users;

import Domain.EventLog;
import Domain.Game;
import Domain.League;
import Service.System;

import java.util.ArrayList;

public class Referee extends User
{
    /** -----Base attributes----- */
    private String qualification;
    /** -----Derivatives attributes----- */
    private ArrayList<EventLog> eventLogs;
    private ArrayList<Game> games;
    private ArrayList<League> leagues;

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public ArrayList<EventLog> getEventLogs() {
        return eventLogs;
    }

    public void setEventLogs(ArrayList<EventLog> eventLogs) {
        this.eventLogs = eventLogs;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public ArrayList<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(ArrayList<League> leagues) {
        this.leagues = leagues;
    }

    public Referee(String name, String userName, String password, boolean isLogged, System system, String qualification, ArrayList<EventLog> eventLogs, ArrayList<Game> games, ArrayList<League> leagues)
    {
        super(name, userName, password, isLogged, system);
        this.qualification = qualification;
        this.eventLogs = eventLogs;
        this.games = games;
        this.leagues = leagues;
    }

    public Referee(String name, String userName, String password, boolean isLogged, String qualification, ArrayList<EventLog> eventLogs, ArrayList<Game> games, ArrayList<League> leagues)
    {
        super(name, userName, password, isLogged);
        this.qualification = qualification;
        this.eventLogs = eventLogs;
        this.games = games;
        this.leagues = leagues;
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
    public void addResult(Game game, String score)
    {
        //TODO - Implement addResult function + change return type
    }

}
