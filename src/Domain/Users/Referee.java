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

    public Referee(String userName, String password, boolean isLogged)
    {
        super(userName, password, isLogged);
    }

    @Override
    public String toString() {
        return "Referee{" +
                "name='" + this.getUserName() + '\'' +
                '}';
    }
}
