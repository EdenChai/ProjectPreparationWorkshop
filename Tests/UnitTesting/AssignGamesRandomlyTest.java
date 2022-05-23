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

public class AssignGamesRandomlyTest {
    DBConnector dbConnector;
    System system;
    ArrayList<Game> arr;
    Team PetahTikva = new Team("Petah Tikva");
    Team Rishon = new Team("Rishon");
    Game game1 = new Game(PetahTikva, Rishon);
    ArrayList<Game> arr2;
    AssociationMember AM;

    @BeforeEach
    void createGames() {
        arr2 = new ArrayList<Game>();
        arr = new ArrayList<Game>();
        AM = new AssociationMember("am", "123",true);
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


}
