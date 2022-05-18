package IntegrationTesting;

import DataAccess.DBController;
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
        DBController dbController = new DBController();
        System system = new System(dbController);
        Team team = new Team();
        player = new Player("Testy", "Testy@test.test", "testytesty", false, system,  "9/05/2022", Position.SWEEPER, team);

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