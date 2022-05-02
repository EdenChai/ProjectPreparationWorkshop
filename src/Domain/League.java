package Domain;

import Domain.Users.AssociationMember;
import Domain.Users.MainReferee;
import Domain.Users.Referee;

import java.util.ArrayList;

/**
 * @author Eden_Hai
 * @version 1.0
 * @since 02-05-2022
 */
public class League
{
    private ArrayList<Game> games;
    private String name;
    private AssociationMember associationMember;
    private ArrayList<Referee> referees;
    private ArrayList<Season> seasons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AssociationMember getAssociationMember() {
        return associationMember;
    }

    public void setAssociationMember(AssociationMember associationMember) {
        this.associationMember = associationMember;
    }

    public ArrayList<Referee> getReferees() {
        return referees;
    }

    public void setReferees(ArrayList<Referee> referees) {
        this.referees = referees;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(ArrayList<Season> seasons) {
        this.seasons = seasons;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
}
