package Domain.Users;

import DataAccess.DBConnector;
import Domain.Game;
import Domain.League;

import java.util.ArrayList;

public class AssociationMember extends User
{
    /** -----Base attributes----- */

    /** -----Derivatives attributes----- */
    private Leage[] leagues;

    /** -----Functions----- */

    public Leage[] getLeagues() {
        return leagues;
    }

    public void setLeagues(Leage[] leagues) {
        this.leagues = leagues;
    }

    /**
     * Makes a new League objects
     */
    public void makeNewLeague()
    {
        //TODO - Implement this function + change return type
    }


    /**
     *
     * @param league - A League object representing the current league
     * Adds a new season to an existing league
     */
    public void addSeasonToLeague(League league)
    {
        //TODO - Implement this function + change return type
    }

    /**
     * Makes a new referee account and adds it
     */
    public void addReferee(Game game) throws Exception {
        if (game.getDate()==null || game.getStadium()==null){
            throw new Exception("pre-conditions are not met");

        }

        if (game.getSeason().getPolicy()==null){
            throw new Exception("policy is not existed :(");
        }

        ArrayList<Referee> referees;
        referees = DBConnector.getInstance().getRefereeByDate(game.getDate());
        Referee referee = null;
        if (referees.size()>0){
            referee= referees.get(0);  // the first referee is chosen
        }
        else{
            throw new Exception("no available referee for this game");
        }

        if (game.getSeason().getPolicy().IsRefereeLegal(game, referee)) {
            throw new Exception("the game doesn't match the policy");
        }
        else{
            game.addReferee(referee);
        }




    }


    /**
     *
     * @param referee - A User from Referee type
     * @param league - A League object representing current league
     * @param season - A Season object representing current season
     * Assigns a referee to a season in a league
     */
    public void assignReferee(User referee, League league, Season season)
    {
        //TODO - Implement this function + change return type
    }

    /**
     * Adds a scoring/assigment policy to a season in a league
     * @param league - A League object representing current league
     * @param season - A Season object representing current season
     */
    public void addPolicy(League league, Season season)
    {
        //TODO - Implement this function + change return type
    }

    /**
     * Edits a scoring/assigment policy to a season in a league
     * @param league - A League object representing current league
     * @param season - A Season object representing current season
     */
    public void editPolicy(League league, Season season)
    {
        //TODO - Implement this function + change return type
    }

    /**
     * Activates the system to assign the games based on the policy
     * @param league - A League object representing current league
     * @param season - A Season object representing current season
     */
    public void activateGameAssignment(League league, Season season)
    {
        //TODO - Implement this function + change return type
    }
}
