package Domain.Users;

import Domain.EventLog;
import Domain.Game;
import Domain.League;
import Service.System;

import java.util.ArrayList;

/**
 * @author Eden_Hai
 * @version 1.0
 * @since 02-05-2022
 */
public class MainReferee extends Referee
{

    public MainReferee(String userName, String password, boolean isLogged, System system, String qualification, ArrayList<EventLog> eventLogs, ArrayList<Game> games, ArrayList<League> leagues)
    {
        super(userName, password, isLogged, system, qualification, eventLogs, games, leagues);
    }

    public MainReferee(String userName, String password, boolean isLogged, String qualification, ArrayList<EventLog> eventLogs, ArrayList<Game> games, ArrayList<League> leagues)
    {
        super(userName, password, isLogged, qualification, eventLogs, games, leagues);
    }
}
