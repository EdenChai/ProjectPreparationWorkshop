package Domain;

import DataAccess.DBConnector;
import Domain.Users.Referee;
import Domain.Users.User;
import Exceptions.UserAlreadyExist;
import Exceptions.UserDoesNotExist;
import javafx.scene.control.RadioMenuItem;

import java.util.ArrayList;
import java.util.Date;

public class main {
    public static void main(String[] args) {
//        IndexPolicy IP = new IndexPolicy();
//        ArrayList<Game> games = new ArrayList<Game>();
//        Team team1 = new Team("team1");
//        Team team2 = new Team("team2");
//        Team team3 = new Team("team3");
//        Team team4 = new Team("team4");
//        Team team5 = new Team("team5");
//        Team team6 = new Team("team6");
//        games.add(new Game(team1, team2));
//        games.add(new Game(team3, team4));
//        games.add(new Game(team5, team6));
//        System.out.println("before policy");
//        System.out.println(games);
//        IP.assignGames(games);
//
//        System.out.println("after policy");
//        System.out.println(games);
//
//        IP.assignReferees(games);
//
//        System.out.println("after assigning referees");
//        System.out.println(games);

        DBConnector DB = DBConnector.getInstance();
        Referee user = new Referee("django", "pood", false);
        Date date = new Date(2023, 1, 20);
        try {
            DB.removeUser("django");

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (UserDoesNotExist e) {
            throw new RuntimeException(e);
        }
    }
}
