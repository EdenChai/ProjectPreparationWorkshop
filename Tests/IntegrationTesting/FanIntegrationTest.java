package IntegrationTesting;

import DataAccess.DBConnector;
import Exceptions.*;
import Service.System;
import Domain.Users.Fan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FanIntegrationTest
{
    Fan fan;
    System system;

    @BeforeEach
    void setUp()
    {
        DBConnector dbConnector = new DBConnector();
        system = new System(dbConnector);
        fan = new Fan("Testy", "testytesty", false);
    }

    @AfterEach
    void tearDown()
    {

    }


    //Test the advanced User objects functions


//    @Test
//    @DisplayName("I.FAN.1 - logOut() function test")
//    void logOut()
//    {
//        assertDoesNotThrow(()->system.logIn("Testy", "testytesty"));
//        assertTrue(fan.isLogged());
//
//        fan.logOut();
//        assertFalse(fan.isLogged());
//
//        assertThrows(UserIsNotLoggedIn.class, ()-> fan.logOut());
//
//    }

    @Test
    @DisplayName("I.FAN.2 - getSystem() function test")
    void getSystem()
    {
        System sys = fan.getSystem();
        assertEquals(system, sys);
    }

    @Test
    @DisplayName("I.FAN.3 - setSystem() function test")
    void setSystem()
    {
        fan.setSystem(null);
        System sys = fan.getSystem();
        assertNull(sys);
        fan.setSystem(system);
        sys = fan.getSystem();
        assertEquals(system, sys);
    }

}