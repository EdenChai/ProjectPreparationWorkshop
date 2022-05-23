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


import DataAccess.DBConnector;
import Domain.Game;
import Domain.Team;
import Service.System;

import java.util.ArrayList;

public class AssignRefereesByIndexTest {
    DBConnector dbConnector;
    System system;
    ArrayList<Game> arr = new ArrayList<Game>();
    Team PetahTikva = new Team("Petah Tikva");
    Team Rishon = new Team("Rishon");
    Game game1 = new Game(PetahTikva, Rishon);

    @Test
    @DisplayName("Assign games By Index")
    void AssignRefereesByIndexNull() {
        assertThrows(NoGamesToAssign.class, () -> system.assignRefereesByIndex(null));
    }


    @Test
    @DisplayName("Assign games no array")
    void AssignByIndexEmptyArray() {
        ArrayList<Game> arr2 = new ArrayList<Game>();
        assertThrows(NoGamesToAssign.class, () -> system.assignRefereesByIndex(arr2));
    }


    //TODO send games with no date assigned
    // TODO send games with no referees availavble in their date
    //TODO send games with no referees availavble only for part of them
    //TODO send games with no dates assigned only for part of them
    //TODO success scenario (date for every game + available referee for every date)
}


