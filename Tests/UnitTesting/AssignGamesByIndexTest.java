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
    Team Rishon = new Team("Rishon");
    Game game1 = new Game(PetahTikva, Rishon);
    Referee notAM;
    AssociationMember AM;
    Stadium stadium1;
    Date date1;
    Date date2;

    @BeforeEach
    void createGamesEraseDBContent() {
        dbConnector.eraseDBContent();
        arr = new ArrayList<Game>();
        AM = new AssociationMember("am", "123",true);
        notAM = new Referee("ref1", "222", true);
        stadium1 = new Stadium("stadiumName", "stadiumCity");
        date1 = new Date(2022,9,6);
        date2 = new Date(2022, 3, 27);
    }

    @Test
    @DisplayName("Assign games by index")
    void AssignByIndexSuccessfully()
    {
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
    void AssignByIndexByDifferentUser()
    {
        dbConnector.addStadiumDate(stadium1, date1);
        arr.add(game1);
        assertThrows(AssignGameByDifferentUser.class,()-> system.assignGamesByIndex(arr, notAM));
    }


    //TODO test where there are more stadiums than games


}
