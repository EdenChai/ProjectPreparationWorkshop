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


public class AssignRefereesRandomlyTest {
    DBConnector dbConnector = DBConnector.getInstance();
    System system = new System(dbConnector);
    ArrayList<Game> arr = new ArrayList<Game>();
    Team PetahTikva = new Team("Petah Tikva");
    Team Rishon = new Team("Rishon");
    Game game1 = new Game(PetahTikva, Rishon);
    Referee notAM;
    AssociationMember AM;
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
    void createGames() {
        ArrayList<Game> arr = new ArrayList<Game>();
        AM = new AssociationMember("am", "123",true);
        notAM = new Referee("ref1", "222", true);
    }


    @Test
    @DisplayName("Assign games By Index")
    void AssignRefereesWithNullArray() {
        assertThrows(NoGamesToAssign.class, () -> system.assignRefereesRandomly(null,AM));
    }


    @Test
    @DisplayName("Assign games no array")
    void AssignWithEmptyArray()
    {
        ArrayList<Game> arr2 = new ArrayList<Game>();
        assertThrows(NoGamesToAssign.class,()-> system.assignRefereesRandomly(arr2, AM));
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignByDifferentUser() throws Exception {
        /*add games to array*/
        arr.add(game1);
        /*assign games*/
        system.assignGamesRandomly(arr, AM);
        assertThrows(AssignRefereesByDifferentUser.class,()-> system.assignRefereesRandomly(arr, notAM));
    }

    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignByNullUser() throws Exception {
        /*add available stadiums by date to DB*/
        dbConnector.addStadiumDate(stadium1, date1);
        /*add games to array*/
        arr.add(game1);
        /*assign games*/
        system.assignGamesRandomly(arr, AM);
        /*check*/
        assertThrows(UserIsNull.class,()-> system.assignRefereesRandomly(arr, null));
    }


    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignGameWithNoDate() throws Exception {
        /*add available stadiums by date to DB*/
        dbConnector.addStadiumDate(stadium1, date1);
        /*add games to array*/
        arr.add(game1);
        /*assign games*/
        system.assignGamesRandomly(arr, AM);
        /*check*/
        assertThrows(GameWithNoDate.class,()-> system.assignRefereesRandomly(arr, AM));

    }


    @Test
    @DisplayName("Assign games By referee not association member")
    void AssignWithNoReferees() throws Exception {
        /*add games to array*/
        arr.add(game1);
        /*add available stadiums by date to DB*/
        dbConnector.addStadiumDate(stadium1, date1);
        /*assign games*/
        system.assignGamesRandomly(arr, AM);
        /*assign referees*/
        system.assignRefereesRandomly(arr,AM);
        /*check*/
        assertTrue(()-> game1.getReferees().size()== 0);
    }




}
