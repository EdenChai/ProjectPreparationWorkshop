package UnitTesting;

import Domain.Team;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamUnitTest
{
    Team team;

    @BeforeEach
    void setUp()
    {
        team = new Team("Testeam");

    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    @DisplayName("U.Team.1 - testToString()function test")
    void testToString()
    {
        assertEquals("Testeam", team.getName());
    }
}