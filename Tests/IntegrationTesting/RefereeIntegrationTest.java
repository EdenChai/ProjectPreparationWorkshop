package IntegrationTesting;

import Domain.Game;
import Domain.Team;
import Domain.Users.Referee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RefereeIntegrationTest
{
    Referee referee;
    ArrayList<Game> games;

    @BeforeEach
    void setUp()
    {
        referee = new Referee("Testy", "testest", false);
        games = new ArrayList<>();
        games.add(new Game(new Team("Team1"), new Team("Team2")));
        games.add(new Game(new Team("Team3"), new Team("Team4")));
        referee.setGames(games);
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    @DisplayName("I.Referee.1 - testToString()function test")
    void getGames()
    {
        assertEquals(games, referee.getGames());
    }


    @Test
    @DisplayName("I.Referee.2 - testToString()function test")
    void setGames()
    {
        ArrayList<Game> games = new ArrayList<>();
        games.add(new Game(new Team("Team2"), new Team("Team3")));
        games.add(new Game(new Team("Team4"), new Team("Team5")));
        assertNotEquals(games, referee.getGames());
        referee.setGames(games);
        assertEquals(games, referee.getGames());

    }

    @Test
    @DisplayName("I.Referee.3 - testToString()function test")
    void testToString()
    {
        assertEquals("Referee{" + "name='" + "Testy" + '\'' + '}', referee.toString());

    }
}