package UnitTesting;
import DataAccess.DBConnector;
import Domain.Game;
import Domain.Team;
import Domain.Users.AssociationMember;
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


public class AssignRefereesRandomlyTest {
    DBConnector dbConnector;
    System system;
    ArrayList<Game> arr = new ArrayList<Game>();
    Team PetahTikva = new Team("Petah Tikva");
    Team Rishon = new Team("Rishon");
    Game game1 = new Game(PetahTikva, Rishon);



    @BeforeEach
    void createGames() {
        ArrayList<Game> arr2 = new ArrayList<Game>();
        AssociationMember AM = new AssociationMember("am", "123",true);
    }


    @Test
    @DisplayName("Assign games By Index")
    void AssignRefereesRandomlyNull() {
        assertThrows(NoGamesToAssign.class, () -> system.assignRefereesRandomly(null));
    }


    @Test
    @DisplayName("Assign games no array")
    void AssignRefereesRandomlyEmptyArray()
    {
        ArrayList<Game> arr2 = new ArrayList<Game>();
        assertThrows(NoGamesToAssign.class,()-> system.assignRefereesRandomly(arr2));
    }

}
