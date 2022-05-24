package Domain;

import Domain.Users.Referee;
import Exceptions.GameWithNoDate;
import Exceptions.LessStadiumsThanGames;
import Exceptions.NoGamesToAssign;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;

public abstract class Policy {


    public abstract Boolean assignGames(ArrayList<Game> games) throws LessStadiumsThanGames, NoGamesToAssign;

    public abstract Boolean assignReferees(ArrayList<Game> games) throws NoGamesToAssign, GameWithNoDate;
}