package UnitTesting;

import Domain.Users.Fan;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static java.time.Duration.ofSeconds;

class FanUnitTest
{
    Fan fan;

    @BeforeEach
    void setUp()
    {
        fan = new Fan("Testy", "testytesty", false);
    }

    @AfterEach
    void tearDown()
    {
    }

//    @Test
//    @DisplayName("U.FAN.1 - updateDetails() function test")
//    void updateDetails()
//    {
//        fan.updateDetails("userName", "TestyReborn");
//        String name = fan.getUserName();
//        assertEquals("TestyReborn", name);
//
//        fan.updateDetails("password", "testytestyreborn");
//        String pass = fan.getPassword();
//        assertEquals("testytestyreborn", pass);
//
//    }

    //Test the basic User objects functions

    @Test
    @DisplayName("U.FAN.2 - getUserName() function test")
    void getUserName()
    {
        String name = fan.getUserName();
        assertEquals("Testy", name);
    }

    @Test
    @DisplayName("U.FAN.3 - setUserName() function test")
    void setUserName()
    {
        fan.setUserName("Testy2");
        String name = fan.getUserName();
        assertEquals("Testy2", name);
    }

    @Test
    @DisplayName("U.FAN.4 - getPassword() function test")
    void getPassword()
    {
        String pass = fan.getPassword();
        assertEquals("testytesty", pass);
    }

    @Test
    @DisplayName("U.FAN.5 - setPassword() function test")
    void setPassword()
    {
        fan.setPassword("testytesty2");
        String pass = fan.getPassword();
        assertEquals("testytesty2", pass);
    }

    @Test
    @DisplayName("U.FAN.6 - isLogged() function test")
    void isLogged()
    {
        boolean logged = fan.isLogged();
        assertFalse(logged);

        fan.setLogged(true);
        logged = fan.isLogged();
        assertTrue(logged);

    }

    @Test
    @DisplayName("U.FAN.7 - setLogged() function test")
    void setLogged()
    {
        fan.setLogged(false);
        boolean logged = fan.isLogged();
        assertFalse(logged);

    }


}