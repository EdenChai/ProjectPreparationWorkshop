package AcceptanceTesting;

import DataAccess.DBConnector;
import Domain.Game;
import Domain.Users.Fan;
import Domain.Users.User;
import Exceptions.*;
import Service.System;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssignGamesAcceptanceTest {


    DBConnector dbConnector;
    System system;

    @BeforeEach
    void setUp()
    {
        dbConnector = new DBConnector();
        system = new System(dbConnector);
        try
        {
            //TODO make sure the logged in user is assosiation member
        }
        catch (Exception ignored)
        {

        }
    }
}
