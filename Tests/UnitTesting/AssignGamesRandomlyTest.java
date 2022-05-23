package UnitTesting;
import DataAccess.DBConnector;
import Domain.Game;
import Domain.Stadium;
import Domain.Team;
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
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignGamesRandomlyTest {
    DBConnector dbConnector;
    System system;
    ArrayList<Game> arr = new ArrayList<Game>();
    Team PetahTikva = new Team("Petah Tikva");
    Team BeerSheva = new Team("BeerSheva");
    Team TLV = new Team("TLV");
    Team Rishon = new Team("Rishon");
    Game game1 = new Game(PetahTikva, Rishon);
    Game game2 = new Game(BeerSheva, TLV);
    Referee notAM = new Referee("ref1", "222", true);
    AssociationMember AM = new AssociationMember("am", "123",true);
    Stadium stadium1 = new Stadium("stadiumName1", "stadiumCity1");
    Stadium stadium2 = new Stadium("stadiumName2", "stadiumCity2");

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
    @DisplayName("Assign games randomly")
    void AssignRandomSuccessfully()
    {
        //TODO make sure there is at least one stadium at the DB
        arr.add(game1);
        assertDoesNotThrow(()-> system.assignGamesRandomly(arr,AM));
    }


    @Test
    @DisplayName("Assign games randomly")
    void AssignRandomEmptyArray()
    {
        ArrayList<Game> arr2 = new ArrayList<Game>();
        AssociationMember AM = new AssociationMember("am", "123",true);
        assertThrows(NoGamesToAssign.class,()-> system.assignGamesRandomly(arr2,AM));
    }



    @Test
    @DisplayName("Assign games randomly")
    void AssignRandomNull()
    {
        assertThrows(NoGamesToAssign.class,()-> system.assignGamesRandomly(null,AM));
    }

    //TODO test where there are more games than stadiums
    //TODO test where there are more stadiums than games

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignByIndexByDifferentUser() throws UserAlreadyExist {
        dbConnector.addStadiumDate(stadium1, date1);
        arr.add(game1);
        assertThrows(AssignGameByDifferentUser.class,()-> system.assignGamesRandomly(arr, notAM));
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignByRandomEventLogExists() throws Exception {
        dbConnector.addStadiumDate(stadium1, date1);
        arr.add(game1);
        system.assignGamesRandomly(arr, AM);
        assertTrue(()-> game1.getEventLogs() != null);
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignByRandomByNullUser() throws UserAlreadyExist {
        dbConnector.addStadiumDate(stadium1, date1);
        arr.add(game1);
        assertThrows(UserIsNull.class,()-> system.assignGamesRandomly(arr, null));
    }

    @Test
    @DisplayName("Assign games not enough stadiums")
    void AssignRandomlySuccessfullyMultipleGames() throws UserAlreadyExist {
        arr.add(game1);
        arr.add(game2);
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium2, date2);
        dbConnector.addStadiumDate(stadium2, date3);
        assertDoesNotThrow(()-> system.assignGamesRandomly( arr, AM));
    }

    @Test
    @DisplayName("Assign games not enough stadiums")
    void AssignRandomlySuccessfullyMultipleDates() throws UserAlreadyExist {
        arr.add(game1);
        arr.add(game2);
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium1, date2);
        dbConnector.addStadiumDate(stadium1, date3);
        assertDoesNotThrow(()-> system.assignGamesRandomly( arr, AM));
    }
}
