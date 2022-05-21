package Domain;

import DataAccess.DBConnector;
import Domain.Users.Referee;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class IndexPolicy extends Policy {

    @Override
    public Boolean assignGames(ArrayList<Game> games) {
        ArrayList<Pair<Date, Stadium>> availableStadiums = DBConnector.getInstance().getAvailableStadiums();
        if (availableStadiums.size() < games.size()) { // Three are not enough stadiums for all the games
            //TODO THROW EXCEPTION
            return false;
        }
        ArrayList<Pair<Date, Stadium>> unavailableStadiums = new ArrayList<>();
        for (int i = 0; i < games.size(); i++) {
            games.get(i).setDate(availableStadiums.get(i).getKey());
            games.get(i).setStadium(availableStadiums.get(i).getValue());
            unavailableStadiums.add(availableStadiums.get(i));
            availableStadiums.remove(i);
        }
//        System.out.println(games);
//        System.out.println(games.get(0).getStadium());
        DBConnector.getInstance().DatesAndStadiumsToMakeAsAssigned(unavailableStadiums);
        return true;
    }


    @Override
    public Boolean assignReferees(ArrayList<Game> games) {
        ArrayList<Pair<Referee, Date>> unavailableReferees = new ArrayList<>();
        ArrayList<Game> cantBeAssigned = new ArrayList<>(); //list of games tht there is no available referee in their date
        HashMap<Date, ArrayList<Referee>> availableReferees = DBConnector.getInstance().getAvailableReferees();
        for (int i = 0; i < games.size(); i++) {
            if (availableReferees.containsKey(games.get(i).getDate())) { // if there is an available referee in the game's date
                Referee theReferee = availableReferees.get(games.get(i).getDate()).get(0);
                games.get(i).addReferee(theReferee);
                Pair<Referee, Date> pairRefereeDate = new Pair<>(theReferee, games.get(i).getDate());
                unavailableReferees.add(pairRefereeDate);
            } else {
                cantBeAssigned.add(games.get(i));
            }
        }
        DBConnector.getInstance().RefereesToMakAsAssigned(unavailableReferees);
        return true;

    }
}