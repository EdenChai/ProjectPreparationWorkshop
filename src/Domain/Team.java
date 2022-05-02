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


}
