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


    public AssociationMember(String userName, String password, boolean isLogged, System system) {
        super(userName, password, isLogged, system);
    }

    public AssociationMember(String userName, String password, boolean isLogged) {
        super(userName, password, isLogged);
    }


    public League[] getLeagues() {
        return leagues;
    }

    public void setLeagues(League[] leagues) {
        this.leagues = leagues;
    }

    /**
     * Makes a new League objects
     */
    public void makeNewLeague() {
        //TODO - Implement this function + change return type
    }


    /**
     * @param league - A League object representing the current league
     *               Adds a new season to an existing league
     */
    public void addSeasonToLeague(League league) {
        //TODO - Implement this function + change return type
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

        /**
         *
         * @param referee - A User from Referee type
         * @param league - A League object representing current league
         * @param season - A Season object representing current season
         * Assigns a referee to a season in a league
         */
        //public void assignReferees(User referee, League league, Season season)
        //{
        //TODO - Implement this function + change return type
        //}


}