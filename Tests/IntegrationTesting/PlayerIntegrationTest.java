package IntegrationTesting;

import DataAccess.DBConnector;
import Domain.Position;
import Domain.Team;
import Domain.Users.Player;
import Service.System;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PlayerIntegrationTest
{
    Player player;
    Team team;

    @BeforeEach
    void setUp()
    {
        DBConnector dbConnector = DBConnector.getInstance();
        System system = new System(dbConnector);
        team = new Team("Alpha");
        player = new Player("Testy", "testytesty", false,"9/05/2022", Position.SWEEPER, team);

    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    @DisplayName("I.PLAYER.1 - getTeam() function test")
    public void getTeam()
    {
        Team teamP = player.getTeam();
        assertEquals(team, teamP);

    }

    @Test
    @DisplayName("I.PLAYER.2 - setTeam() function test")
    public void setTeam(Team team)
    {
        Team team2 = new Team("Beta");
        Team teamP = player.getTeam();
        assertNotEquals(team, teamP);
        player.setTeam(team2);
        teamP = player.getTeam();
        assertEquals(team, teamP);
    }



}