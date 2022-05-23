package Domain;

import Domain.Users.MainReferee;
import Domain.Users.Referee;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Eden_Hai
 * @version 1.0
 * @since 02-05-2022
 */
public class Game
{
    private String score;
    private Date date;
    private Team home;
    private Team away;
    private ArrayList<Referee> referees;
    private Stadium stadium;
    private ArrayList<EventLog> eventLogs;
    private MainReferee mainReferee;
    private League league;
    private Season season;

    public Game(Team home, Team away) {
        this.home = home;
        this.away = away;
        this.eventLogs = new ArrayList<EventLog>();
        this.referees = new ArrayList<Referee>();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addReferee(Referee referee){
        this.referees.add(referee);
    }
    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public ArrayList<Referee> getReferees() {
        return referees;
    }

    public void setReferees(ArrayList<Referee> referees) {
        this.referees = referees;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
        stadium.addGame(this);
    }

    public ArrayList<EventLog> getEventLogs() {
        return eventLogs;
    }

    public void setEventLogs(ArrayList<EventLog> eventLogs) {
        this.eventLogs = eventLogs;
    }

    public MainReferee getMainReferee() {
        return mainReferee;
    }

    public void setMainReferee(MainReferee mainReferee) {
        this.mainReferee = mainReferee;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    @Override
    public String toString() {
        String stadiumName = null;
        if (this.stadium != null){
            stadiumName = this.stadium.getName();
        }
        return "Game{" +
                "score='" + score + '\'' +
                ", date=" + date +
                ", home=" + home +
                ", away=" + away +
                ", referees=" + referees +
                ", stadium=" + stadiumName +
                ", eventLogs=" + eventLogs +
                ", mainReferee=" + mainReferee +
                ", league=" + league +
                ", season=" + season +
                '}';
    }
}


