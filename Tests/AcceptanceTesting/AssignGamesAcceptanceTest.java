package AcceptanceTesting;

import DataAccess.DBConnector;
import Domain.Game;
import Domain.Stadium;
import Domain.Team;
import Domain.Users.AssociationMember;
import Exceptions.*;
import Service.System;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AssignGamesAcceptanceTest {
    DBConnector dbConnector = DBConnector.getInstance();
    System system = new System(dbConnector);
    ArrayList<Game> arr = new ArrayList<Game>();
    Team MacabiHaifa = new Team("MacabiHaifa");
    Team MacabiTelAviv = new Team("MacabiTelAviv");
    Game game1 = new Game(MacabiHaifa, MacabiTelAviv);
    AssociationMember AM = new AssociationMember("am", "123",true);
    Stadium stadium1 = new Stadium("stadiumName1", "stadiumCity1");
    Stadium stadium2 = new Stadium("stadiumName2", "stadiumCity2");
    Stadium stadium3 = new Stadium("stadiumName3", "stadiumCity3");
    Team PetahTikva = new Team("Petah Tikva");
    Team BeerSheva = new Team("BeerSheva");
    Team TLV = new Team("TLV");
    Team Rishon = new Team("Rishon");
    Game game3 = new Game(PetahTikva, Rishon);
    Game game2 = new Game(BeerSheva, TLV);
    Date date1 = new Date(2022,12,29);
    Date date2 = new Date(2022, 6, 27);
    Date date3 = new Date(2022, 8, 18);
    Date date4 = new Date(2022, 9, 1);

    @BeforeEach
    void createGamesEraseDBContent() {
        dbConnector.eraseDBContent();
        arr = new ArrayList<Game>();
    }

    @Test
    @DisplayName("A.INDEXPOLICY.1 - AssignGameByIndex() function test")
    void AssignGameByIndex() throws Exception {
        /*add available stadium to DB*/
        dbConnector.addStadiumDate(stadium1, date1);
        /*add games to array*/
        arr.add(game1);
        /*assign game*/
        system.assignGamesByIndex(arr, AM);
        /*CHECK*/
        assertTrue(()-> game1.getDate()==date1);
    }



    @Test
    @DisplayName("A.RANDOMPOLICY.1 - AssignByIndexNoStadiums() function test")
    void AssignByIndexNoStadiums()
    {
        /*add game to array*/
        arr.add(game1);
        /*CHECK*/
        assertThrows(LessStadiumsThanGames.class,()-> system.assignGamesByIndex(arr,AM));
    }

    @Test
    @DisplayName("A.RANDOMPOLICY.2 - AssignSuccessfullyThreeRandomGames() function test")
    void AssignSuccessfullyThreeRandomGames() throws Exception {
        /*add available stadiums to DB*/
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium2, date2);
        dbConnector.addStadiumDate(stadium3, date3);
        /*add games to array*/
        arr.add(game1);
        arr.add(game2);
        arr.add(game3);
        /*assign games*/
        system.assignGamesRandomly(arr, AM);
        /*CHECK*/
        ArrayList<Date> DateArr = new ArrayList<Date>();
        DateArr.add(date1);
        DateArr.add(date2);
        DateArr.add(date3);
        assertTrue(()-> game1.getDate()!= game2.getDate() && game1.getDate()!= game3.getDate() && game2.getDate()!= game3.getDate() && DateArr.contains(game1.getDate()) && DateArr.contains(game1.getDate()) && DateArr.contains(game1.getDate()));
    }

}
