package Domain;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        IndexPolicy IP = new IndexPolicy();
        ArrayList<Game> games = new ArrayList<Game>();
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        Team team3 = new Team("team3");
        Team team4 = new Team("team4");
        Team team5 = new Team("team5");
        Team team6 = new Team("team6");
        games.add(new Game(team1, team2));
        games.add(new Game(team3, team4));
        games.add(new Game(team5, team6));
        IP.assignGames(games);

    }
}