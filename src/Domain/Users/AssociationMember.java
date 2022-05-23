package Domain.Users;

import Domain.*;
import Service.System;

import java.util.ArrayList;

public class AssociationMember extends User {
    /** -----Base attributes----- */

    /**
     * -----Derivatives attributes-----
     */
    private League[] leagues;
    private IndexPolicy indexPolicy;
    private RandomPolicy randomPolicy;
    /**
     * -----Functions-----
     */



    public AssociationMember(String userName, String password, boolean isLogged) {
        super(userName, password, isLogged);
    }

    /**
     * @param games we want to assign
     * @throws Exception
     */
    public void assignGamesRandomly(ArrayList<Game> games) throws Exception {
        randomPolicy.assignGames(games);
    }

    public void assignGamesByIndex(ArrayList<Game> games) throws Exception {
        indexPolicy.assignGames(games);
    }


    public void assignRefereesRandomly(ArrayList<Game> games) throws Exception {
        randomPolicy.assignReferees(games);
    }

    public void assignRefereesByIndex(ArrayList<Game> games) throws Exception {
        indexPolicy.assignReferees(games);
    }


}