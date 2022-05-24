package UnitTesting;
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

public class AssignRefereesByIndexTest {
    DBConnector dbConnector = DBConnector.getInstance();
    System system = new System(dbConnector);
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
    @DisplayName("Assign games By Index")
    void AssignRefereesGamesAreNull() {
        assertThrows(NoGamesToAssign.class, () -> system.assignRefereesByIndex(null, AM));
    }

    @Test
    @DisplayName("Assign games no array")
    void AssignEmptyArray() {
        assertThrows(NoGamesToAssign.class, () -> system.assignRefereesByIndex(arr, AM));
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignByIndexByDifferentUser() throws UserAlreadyExist {
        game1.setDate(date1);
        arr.add(game1);
        assertThrows(AssignRefereesByDifferentUser.class,()-> system.assignRefereesByIndex(arr, notAM));
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignByIndexByNullUser() throws UserAlreadyExist {
        dbConnector.addStadiumDate(stadium1, date1);
        game1.setDate(date1);
        arr.add(game1);
        assertThrows(UserIsNull.class,()-> system.assignRefereesByIndex(arr, null));
    }


    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignGameWithNoDate() throws UserAlreadyExist {
        dbConnector.addStadiumDate(stadium1, date1);
        arr.add(game1);
        assertThrows(GameWithNoDate.class,()-> system.assignRefereesByIndex(arr, AM));

    }
}