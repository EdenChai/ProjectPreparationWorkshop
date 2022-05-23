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

public class AssignGamesByIndexTest {
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
    @DisplayName("Assign games by index")
    void AssignByIndexSuccessfully() throws UserAlreadyExist {
        //TODO make sure there is at least one stadium at the DB
        dbConnector.addStadiumDate(stadium1, date1);
        arr.add(game1);
        assertDoesNotThrow(()-> system.assignGamesByIndex(arr, AM));
    }

    @Test
    @DisplayName("Assign games not enough stadiums")
    void AssignByIndexNotEnoughStadiums()
    {
        arr.add(game1);
        assertThrows(LessStadiumsThanGames.class,()-> system.assignGamesByIndex(arr,AM));
    }

    @Test
    @DisplayName("Assign games By Index NoGamesToAssign")
    void AssignByIndexEmptyArray()
    {
        ArrayList<Game> arr2 = new ArrayList<Game>(); //array list is empty
        assertThrows(NoGamesToAssign.class,()-> system.assignGamesByIndex(arr2, AM));
    }


    @Test
    @DisplayName("Assign games By Index")
    void AssignByIndexNull()
    {
        assertThrows(NoGamesToAssign.class,()-> system.assignGamesByIndex(null, AM));
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignByIndexByDifferentUser() throws UserAlreadyExist {
        dbConnector.addStadiumDate(stadium1, date1);
        arr.add(game1);
        assertThrows(AssignGameByDifferentUser.class,()-> system.assignGamesByIndex(arr, notAM));
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignByIndexEventLogExists() throws Exception {
        dbConnector.addStadiumDate(stadium1, date1);
        arr.add(game1);
        system.assignGamesByIndex(arr, AM);
        assertTrue(()-> game1.getEventLogs() != null);
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignByIndexByNullUser() throws UserAlreadyExist {
        dbConnector.addStadiumDate(stadium1, date1);
        arr.add(game1);
        assertThrows(UserIsNull.class,()-> system.assignGamesByIndex(arr, null));
    }

    @Test
    @DisplayName("Assign games not enough stadiums")
    void AssignByIndexSuccessfullyMultipleGames() throws UserAlreadyExist {
        arr.add(game1);
        arr.add(game2);
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium2, date2);
        dbConnector.addStadiumDate(stadium2, date3);
        assertDoesNotThrow(()-> system.assignGamesByIndex(arr, AM));
    }

    @Test
    @DisplayName("Assign games not enough stadiums")
    void AssignByIndexSuccessfullyMultipleDates() throws UserAlreadyExist {
        arr.add(game1);
        arr.add(game2);
        dbConnector.addStadiumDate(stadium1, date1);
        dbConnector.addStadiumDate(stadium1, date2);
        dbConnector.addStadiumDate(stadium1, date3);
        assertDoesNotThrow(()-> system.assignGamesByIndex( arr, AM));
    }


}
