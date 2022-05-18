package UnitTesting;

import Domain.Position;
import Domain.Users.Fan;
import Domain.Users.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerUnitTest
{
    Player player;

    @BeforeEach
    void setUp()
    {
        player = new Player("Testy", "Testy@test.test", "testytesty", false, "9/05/2022", Position.SWEEPER);

    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    @DisplayName("U.PLAYER.1 - updateDetails() function test")
    void updateDetails()
    {
        player.updateDetails("userName", "TestyReborn@test.test");
        String name = player.getUserName();
        assertEquals("TestyReborn@test.test", name);

        player.updateDetails("password", "testytestyreborn");
        String pass = player.getPassword();
        assertEquals("testytestyreborn", pass);

        player.updateDetails("birthDay", "10/05/2022");
        String bday = player.getBirthDay();
        assertEquals("10/05/2022", bday);

        player.updateDetails("position", Position.STRIKER);
        Position pos= player.getPosition();
        assertEquals(Position.STRIKER, pos);
    }

    @Test
    @DisplayName("U.PLAYER.2 - getBirthDay() function test")
    void getBirthDay()
    {

    }

    @Test
    @DisplayName("U.PLAYER.3 - setBirthDay() function test")
    void setBirthDay()
    {

    }

    @Test
    @DisplayName("U.PLAYER.4 - setPosition() function test")
    void setPosition()
    {

    }

    @Test
    @DisplayName("U.PLAYER.5 - getPosition() function test")
    void getPosition()
    {

    }

}