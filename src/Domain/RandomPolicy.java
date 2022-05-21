package Domain;

import DataAccess.DBConnector;
import Domain.Users.Referee;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class RandomPolicy extends Policy{


    @Override
    public Boolean assignGames(ArrayList<Game> games) {
        ArrayList<Pair<Date, Stadium>> availableStadiums = DBConnector.getInstance().getAvailableStadiums();
        if(availableStadiums.size()<games.size()){ // There are not enough stadiums for all the games
           //TODO THROW EXCEPTION
            return false;}
        ArrayList<Pair<Date, Stadium>> unavailableStadiums = new ArrayList<>();
        for(int i=0; i< games.size(); i++) {
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(availableStadiums.size());
            games.get(i).setDate(availableStadiums.get(randomInt).getKey());
            games.get(i).setStadium(availableStadiums.get(randomInt).getValue());
            unavailableStadiums.add(availableStadiums.get(randomInt));
            availableStadiums.remove(randomInt);
            DBConnector.getInstance().DatesAndStadiumsToMakeAsAssigned(unavailableStadiums);
        }
        return true;
    }

    @Override
    public Boolean assignReferees(ArrayList<Game> games) {
        ArrayList<Pair<Referee,Date>> unavailableReferees = new ArrayList<>();
        ArrayList<Game> cantBeAssigned = new ArrayList<>(); //list of games tht there is no available referee in their date
        HashMap<Date, ArrayList<Referee>> availableReferees = DBConnector.getInstance().getAvailableReferees();
        for(int i=0; i<games.size(); i++){
            if(availableReferees.containsKey(games.get(i).getDate())){ // if there is an available referee in the game's date
                Random randomGenerator = new Random();
                int randomInt = randomGenerator.nextInt(availableReferees.get(games.get(i).getDate()).size()); //get a random referee from the referees that ae available in the specific date
                Referee theReferee = availableReferees.get(games.get(i).getDate()).get(randomInt);
                games.get(i).addReferee(theReferee);
                Pair<Referee,Date> pairRefereeDate = new Pair<>(theReferee,games.get(i).getDate());
                unavailableReferees.add(pairRefereeDate);}
            else{
                cantBeAssigned.add(games.get(i));
            }
        }
        DBConnector.getInstance().RefereesToMakAsAssigned(unavailableReferees);
        return true;


    }
}
