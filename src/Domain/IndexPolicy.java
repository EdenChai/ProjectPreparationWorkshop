package Domain;

import DataAccess.DBConnector;
import Domain.Users.Referee;
import Exceptions.LessStadiumsThanGames;
import Exceptions.NoGamesToAssign;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class IndexPolicy extends Policy {

    @Override
    public Boolean assignGames(ArrayList<Game> games) throws NoGamesToAssign, LessStadiumsThanGames {
        if (games==null || games.size()==0){
            throw new NoGamesToAssign("No games were sent to be assigned");
        }
        ArrayList<Pair<Date, Stadium>> availableStadiums = DBConnector.getInstance().getAvailableStadiums();
        if (availableStadiums.size() < games.size()) { // Three are not enough stadiums for all the games
            throw new LessStadiumsThanGames("Not enough stadiums to assign all the games");
         }
        ArrayList<Pair<Date, Stadium>> unavailableStadiums = new ArrayList<>();
        for (int i = 0; i < games.size(); i++) {
            games.get(i).setDate(availableStadiums.get(i).getKey());
            games.get(i).setStadium(availableStadiums.get(i).getValue());
            unavailableStadiums.add(availableStadiums.get(i));
            availableStadiums.remove(i);
        }
        DBConnector.getInstance().DatesAndStadiumsToMakeAsAssigned(unavailableStadiums);
        return true;
    }


    @Override
    public Boolean assignReferees(ArrayList<Game> games) throws NoGamesToAssign {
        if (games==null || games.size()==0){
            throw new NoGamesToAssign("No games were sent to be assigned");
        }
        ArrayList<Pair<Referee, Date>> unavailableReferees = new ArrayList<>();
        ArrayList<Game> cantBeAssigned = new ArrayList<>(); //list of games tht there is no available referee in their date
        HashMap<Date, ArrayList<Referee>> availableReferees = DBConnector.getInstance().getAvailableReferees();
        for (int i = 0; i < games.size(); i++) {
            if (availableReferees.containsKey(games.get(i).getDate())) { // if there is an available referee in the game's date
                Referee theReferee = availableReferees.get(games.get(i).getDate()).get(0);
                games.get(i).addReferee(theReferee);
                availableReferees.get(games.get(i).getDate()).remove(0);
                if (availableReferees.get(games.get(i).getDate()).size() == 0){
                    availableReferees.remove(games.get(i).getDate());
                }
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