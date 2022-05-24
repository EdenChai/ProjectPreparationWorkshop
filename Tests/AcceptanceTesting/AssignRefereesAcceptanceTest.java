package AcceptanceTesting;

import DataAccess.DBConnector;
import Domain.Game;
import Domain.Stadium;
import Domain.Team;
import Domain.Users.AssociationMember;
import Domain.Users.Referee;
import Service.System;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignRefereesAcceptanceTest {
    DBConnector dbConnector = DBConnector.getInstance();
    System system = new System(dbConnector);
    ArrayList<Game> arr = new ArrayList<Game>();
    Team MacabiHaifa = new Team("MacabiHaifa");
    Team MacabiTelAviv = new Team("MacabiTelAviv");
    Team BeerSheva = new Team("BeerSheva");
    Team TLV = new Team("TLV");
    Team Rishon = new Team("Rishon");
    Game game1 = new Game(MacabiHaifa, MacabiTelAviv);
    Game game2 = new Game(BeerSheva, Rishon);
    Game game3 = new Game(BeerSheva, Rishon);
    Game game4 = new Game(BeerSheva, Rishon);

    AssociationMember AM = new AssociationMember("am", "123",true);
    Stadium stadium1 = new Stadium("stadiumName1", "stadiumCity1");
    Stadium stadium3 = new Stadium("stadiumName3", "stadiumCity3");
    Stadium stadium4 = new Stadium("stadiumName4", "stadiumCity4");
    Referee Sapir = new Referee("Sapir Berman", "123", false);
    Referee Shani = new Referee("Shani", "246", false);
    Referee Noa = new Referee("Noa", "333", false);
    Referee Hadar = new Referee("Hadar", "555", false);
    Date date1 = new Date(2022,12,29);
    Date date2 = new Date(2022, 6, 18);
    Date date3 = new Date(2022, 8, 18);
    Date date4 = new Date(2022, 6, 27);

    @BeforeEach
    void createGamesEraseDBContent() {
        dbConnector.eraseDBContent();
        arr = new ArrayList<Game>();


    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignRefereesSuccessfullyRandomGamesIndexReferees() throws Exception {
        /*add stadium to DB*/
        dbConnector.addStadiumDate(stadium1, date1);
        /*add referee to DB*/
        dbConnector.addRefereeDate(Sapir, date1);
        arr.add(game1);
        /*assign game*/
        system.assignGamesRandomly(arr, AM);
        /*assign referee to game*/
        system.assignRefereesByIndex(arr, AM);
        /*check assign referees*/
        assertTrue(()-> game1.getDate()==date1 && game1.getReferees().get(0)==Sapir);
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignRefereesRandomlyNoReferee() throws Exception {
        /*add stadium to DB*/
        dbConnector.addStadiumDate(stadium1, date2);
        arr.add(game1);
        /*assign game*/
        system.assignGamesRandomly(arr, AM);
        /*assign referee to game*/
        system.assignRefereesRandomly(arr, AM);
        /*check assign referee*/
        assertTrue(()-> game1.getDate()==date1 && game1.getReferees().size()==0);
    }


    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignRefereesSuccessfully() throws Exception {
        /*add stadiums to DB*/
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium3, date3);
        dbConnector.addStadiumDate(stadium4, date4);
        /*add referees to DB*/
        dbConnector.addRefereeDate(Shani, date1);
        dbConnector.addRefereeDate(Hadar, date2);
        dbConnector.addRefereeDate(Noa, date4);
        dbConnector.addRefereeDate(Noa, date3);
        /*add games to array*/
        arr.add(game2);
        arr.add(game3);
        arr.add(game4);
        /*assign games*/
        system.assignGamesRandomly(arr, AM);
        /*assign referees to games*/
        system.assignRefereesByIndex(arr, AM);
        /*check assign referees*/
        ArrayList<Referee> arrRef = new ArrayList<Referee>();
        arrRef.add(Shani);
        arrRef.add(Noa);
        assertTrue(()-> arrRef.contains(game2.getReferees().get(0)) && arrRef.contains(game3.getReferees().get(0)) && arrRef.contains(game4.getReferees().get(0)));
    }
}
