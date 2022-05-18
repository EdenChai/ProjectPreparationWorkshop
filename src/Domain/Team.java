package Domain;

import Domain.Users.Coach;
import Domain.Users.Player;
import Domain.Users.TeamManager;
import Domain.Users.TeamOwner;

import java.util.ArrayList;

/**
 * @author Eden_Hai
 * @version 1.0
 * @since 02-05-2022
 */
public class Team
{
    private ArrayList<TeamManager> teamManagers;
    private Coach coach;
    private ArrayList<Player> players;
    private TeamOwner teamOwner;
    private ArrayList<Game> homeGames;
    private ArrayList<Game> awayGames;
    private String name;
    private Stadium homeStadium;

    public Team(String name) {
        this.name = name;
    }

    public ArrayList<TeamManager> getTeamManagers() {
        return teamManagers;
    }

    public void setTeamManagers(ArrayList<TeamManager> teamManagers) {
        this.teamManagers = teamManagers;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public TeamOwner getTeamOwner() {
        return teamOwner;
    }

    public void setTeamOwner(TeamOwner teamOwner) {
        this.teamOwner = teamOwner;
    }

    public ArrayList<Game> getHomeGames() {
        return homeGames;
    }

    public void setHomeGames(ArrayList<Game> homeGames) {
        this.homeGames = homeGames;
    }

    public ArrayList<Game> getAwayGames() {
        return awayGames;
    }

    public void setAwayGames(ArrayList<Game> awayGames) {
        this.awayGames = awayGames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stadium getHomeStadium() {
        return homeStadium;
    }

    public void setHomeStadium(Stadium homeStadium) {
        this.homeStadium = homeStadium;
    }
}
