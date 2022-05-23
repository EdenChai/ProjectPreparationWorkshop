package UnitTesting;
import DataAccess.DBConnector;
import Domain.Game;
import Domain.Team;
import Domain.Users.Fan;
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

public class AssignGamesByIndexTest {
    DBConnector dbConnector;
    System system;
    ArrayList<Game> arr = new ArrayList<Game>();
    Team PetahTikva = new Team("Petah Tikva");
    Team Rishon = new Team("Rishon");
    Game game1 = new Game(PetahTikva, Rishon);


    @Test
    @DisplayName("Assign games by index")
    void AssignByIndexSuccessfully()
    {
        //TODO make sure there is at least one stadium at the DB
        arr.add(game1);
        assertDoesNotThrow(()-> system.assignGamesByIndex(arr));
    }

    @Test
    @DisplayName("Assign games randomly")
    void AssignByIndexEmptyArray()
    {
        ArrayList<Game> arr2 = new ArrayList<Game>();
        assertThrows(NoGamesToAssign.class,()-> system.assignGamesByIndex(arr2));
    }


    @Test
    @DisplayName("Assign games By Index")
    void AssignByIndexNull()
    {
        assertThrows(NoGamesToAssign.class,()-> system.assignGamesByIndex(null));
    }

    //TODO test where there are more games than stadiums
    //TODO test where there are more stadiums than games

}
