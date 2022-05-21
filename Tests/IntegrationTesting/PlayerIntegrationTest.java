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

class PlayerIntegrationTest
{
    Player player;

    @BeforeEach
    void setUp()
    {
        DBConnector dbConnector = new DBConnector();
        System system = new System(dbConnector);
        Team team = new Team("Test");
        player = new Player("Testy", "testytesty", false, system,  "9/05/2022", Position.SWEEPER, team);

    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    @DisplayName("I.PLAYER.1 - getTeam() function test")
    public void getTeam()
    {

    }

    @Test
    @DisplayName("I.PLAYER.2 - setTeam() function test")
    public void setTeam(Team team)
    {

    }



}