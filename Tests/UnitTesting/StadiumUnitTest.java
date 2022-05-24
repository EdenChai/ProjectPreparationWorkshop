package UnitTesting;

import Domain.Stadium;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StadiumUnitTest
{
    Stadium stadium;

    @BeforeEach
    void setUp()
    {
        stadium = new Stadium("Testuim", "Testcity");
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    @DisplayName("U.Stadium.1 - testToString() function test")
    void testToString()
    {
        assertEquals("Stadium{" +
                "games=[]"  + ", name='" + "Testuim" + '\'' + ", city='" + "Testcity" + '\'' + '}',stadium.toString());
    }


    @Test
    @DisplayName("U.Stadium.2 - getName() function test")
    void getName()
    {
        assertEquals("Testuim", stadium.getName());
    }

    @Test
    @DisplayName("U.Stadium.3 - getCity() function test")
    void getCity()
    {
        assertEquals("Testcity", stadium.getCity());
    }
}