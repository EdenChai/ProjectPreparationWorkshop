package AcceptanceTesting;

import DataAccess.DBConnector;
import Domain.Users.Fan;
import Domain.Users.User;
import Exceptions.*;
import Service.System;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogInrAcceptanceTest
{
    DBConnector dbConnector;
    System system;

    @BeforeEach
    void setUp()
    {
        dbConnector = new DBConnector();
        system = new System(dbConnector);
        try
        {
        system.registerFan("validname", "HardPass#@!", false, system);
        }
        catch (Exception ignored)
        {

        }
    }

    @AfterEach
    void tearDown()
    {
        try
        {
            dbConnector.removeUser("validname");
        }
        catch (UserDoesNotExist ignored)
        {

        }
    }

    @Test
    @DisplayName("A.LogIn.1 - success test")
    void success()
    {
        assertDoesNotThrow(()-> system.logIn("validname", "HardPass#@!"));
    }

    @Test
    @DisplayName("A.LogIn.2 - userDoesNotExist test")
    void userDoesNotExist()
    {
        assertThrows(UserDoesNotExist.class, ()-> system.logIn("newvalidname", "HardPass#@!"));
    }

    @Test
    @DisplayName("A.LogIn.3 - userAlreadyLoggedIn test")
    void userAlreadyLoggedIn()
    {
        assertDoesNotThrow(()-> system.logIn("validname", "HardPass#@!"));
        assertThrows(UserIsAlreadyLoggedIn.class,()-> system.logIn("validname", "HardPass#@!"));
    }

    @Test
    @DisplayName("A.LogIn.4 - invalidPassword test")
    void invalidPassword ()
    {
        assertThrows(UserPasswordDoesNotMatch.class,()-> system.logIn("validname", "notCorrectPassword"));
    }
}
