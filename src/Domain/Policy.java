package Domain;

import Domain.Users.Referee;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;

public abstract class Policy {


    public abstract Boolean assignGames(ArrayList<Game> games);

    public abstract Boolean assignReferees(ArrayList<Game> games);
}