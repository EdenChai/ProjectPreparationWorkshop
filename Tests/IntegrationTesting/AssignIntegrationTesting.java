package IntegrationTesting;

import DataAccess.DBConnector;
import Domain.*;
import Domain.Users.AssociationMember;
import Domain.Users.Fan;
import Domain.Users.Referee;
import Domain.Users.User;
import Service.System;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Exceptions.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;


import DataAccess.DBConnector;
import Domain.Game;
import Domain.Team;
import Service.System;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignIntegrationTesting {
    DBConnector dbConnector = DBConnector.getInstance();
    System system = new System(dbConnector);
    ArrayList<Game> arr = new ArrayList<Game>();
    Team PetahTikva = new Team("Petah Tikva");
    Team BeerSheva = new Team("BeerSheva");
    Team TLV = new Team("TLV");
    Team Rishon = new Team("Rishon");
    Game game1 = new Game(PetahTikva, Rishon);
    Game game2 = new Game(BeerSheva, TLV);
    Game game3 = new Game(BeerSheva, Rishon);
    Referee notAM = new Referee("ref1", "222", true);
    AssociationMember AM = new AssociationMember("am", "123",true);
    Stadium stadium1 = new Stadium("stadiumName1", "stadiumCity1");
    Stadium stadium2 = new Stadium("stadiumName2", "stadiumCity2");
    Referee referee1 = new Referee("Hadar", "123", true);
    Referee referee2 = new Referee("Noa", "1234", true);
    Referee referee3 = new Referee("Shani", "1234", true);


    Date date1 = new Date(2022,9,6);
    Date date2 = new Date(2022, 3, 27);
    Date date3 = new Date(2022, 8, 18);
    Date date4 = new Date(2022, 4, 1);

    @BeforeEach
    void createGamesEraseDBContent() {
        dbConnector.eraseDBContent();
        arr = new ArrayList<Game>();


    }


    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignRefereesSuccessfullyByIndex() throws Exception {
        /*add games to array*/
        arr.add(game1);
        arr.add(game2);
        /*add available stadiums by date to DB*/
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium2, date2);
        dbConnector.addStadiumDate(stadium2, date3);
        dbConnector.addRefereeDate(referee1, date1);
        dbConnector.addRefereeDate(referee2, date2);
        dbConnector.addRefereeDate(referee3, date3);
        /*assign games*/
        system.assignGamesByIndex(arr, AM);
        /*assign referees*/
        system.assignRefereesByIndex(arr, AM);
        /*check*/
        assertTrue(()-> game1.getReferees().size()>0 && game2.getReferees().size()>0);
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void NoRefereesToAssign() throws Exception {
        dbConnector.addStadiumDate(stadium1, date1);
        /*add games to array*/
        arr.add(game1);
        arr.add(game2);
        /*add available stadiums to DB*/
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium2, date2);
        dbConnector.addStadiumDate(stadium2, date3);
        /*assign games*/
        system.assignGamesByIndex(arr, AM);
        /*assign referees*/
        system.assignRefereesByIndex(arr, AM);
        /*check*/
        assertTrue(()-> game1.getReferees().size()==0 && game2.getReferees().size()==0);
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void SomeDatesWithNoAvailableReferee() throws Exception {
        /*add games to array*/
        arr.add(game1);
        arr.add(game2);
        arr.add(game3);
        /*add available stadiums to DB*/
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium2, date2);
        dbConnector.addStadiumDate(stadium2, date3);
        dbConnector.addRefereeDate(referee1, date1);
        dbConnector.addRefereeDate(referee2, date2);
        dbConnector.addRefereeDate(referee3, date1);
        /*assign games*/
        system.assignGamesByIndex(arr, AM);
        /*assign referees*/
        system.assignRefereesByIndex(arr, AM);
        /*check*/
        assertTrue(()-> game1.getReferees().size()+game2.getReferees().size()+game2.getReferees().size()==2);
    }




    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignRefereesSuccessfullyRandomGamesIndexReferees() throws Exception {
        /*add games to array*/
        arr.add(game1);
        arr.add(game2);
        /*add available stadiums to DB*/
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addRefereeDate(referee1, date1);
        dbConnector.addRefereeDate(referee2, date2);
        dbConnector.addRefereeDate(referee3, date3);
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium2, date2);
        dbConnector.addStadiumDate(stadium2, date3);
        /*assign games*/
        system.assignGamesRandomly(arr, AM);
        /*assign referees*/
        system.assignRefereesByIndex(arr, AM);
        /*check*/
        assertTrue(()-> game1.getReferees().size()>0 && game2.getReferees().size()>0);
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignRefereesSuccessfullyRandom() throws Exception {
        /*add games to array*/
        arr.add(game1);
        arr.add(game2);
        /*add available stadiums to DB*/
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addRefereeDate(referee1, date1);
        dbConnector.addRefereeDate(referee2, date2);
        dbConnector.addRefereeDate(referee3, date3);
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium2, date2);
        dbConnector.addStadiumDate(stadium2, date3);
        /*assign games*/
        system.assignGamesRandomly(arr, AM);
        /*assign referees*/
        system.assignRefereesRandomly(arr, AM);
        /*check*/
        assertTrue(()-> game1.getReferees().size()>0 && game2.getReferees().size()>0);
    }


}
