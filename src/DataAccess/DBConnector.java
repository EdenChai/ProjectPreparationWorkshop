package DataAccess;

import Domain.Stadium;
import Domain.Users.Referee;
import javafx.util.Pair;

//import java.sql.*;
//import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;

public class DBConnector {
    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String USER = "root";
    public static final String PASS = "root";

    private static final DBConnector instance = new DBConnector();

    //private constructor to avoid client applications to use constructor
    public static DBConnector getInstance(){
        return instance;
    }

    public void DatesAndStadiumsToMakeAsAssigned(ArrayList<Pair<Date, Stadium>>  datesAndStadiums){ // TODO CONNECT WITH DB
        //mark the referees as assigned in the DB
    }
    public void RefereesToMakAsAssigned(ArrayList<Pair<Referee, Date>> unavailableReferees) { // TODO CONNECT WITH DB
        //mark the referees as assigned in the DB
    }
    public ArrayList<Pair<Date, Stadium>> getAvailableStadiums(){
        //TODO get the stadium, date tuples of the available ones
        return(null);
        }
    public HashMap<Date, ArrayList<Referee>> getAvailableReferrees(){
        //TODO get ta hashmap, of date as keys and referees arraylist as value
        return(null);
    }

    public HashMap<Date, ArrayList<Stadium>> getStadiumsAndDates(){ //TODO CONNECT WITH DB
        return new HashMap<Date, ArrayList<Stadium>>();
    }

    private DBConnector() {

    }
    /**
     * Get a connection to database
     *
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //return DriverManager.getConnection(URL, USER, PASS);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root", "root");

            return conn;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
     /**
         * Test Connection
         */


}
