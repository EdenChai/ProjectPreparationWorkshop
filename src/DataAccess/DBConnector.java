package DataAccess;

import Domain.Stadium;
import Domain.Users.Referee;
import javafx.util.Pair;

//import java.sql.*;
//import java.sql.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;

public class DBConnector {
    public static final String URL = "jdbc:mysql://localhost:3306/assignment3_db";
    public static final String USER = "root";
    public static final String PASS = "Arnon1";

    Statement statement;


    private static final DBConnector instance = new DBConnector();

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //private constructor to avoid client applications to use constructor
    public static DBConnector getInstance(){
        return instance;
    }

    public static Connection getConnection()
    {
        return null;
    }

    public void DatesAndStadiumsToMakeAsAssigned(ArrayList<Pair<Date, Stadium>>  datesAndStadiums){ // TODO CONNECT WITH DB
        //mark the referees as assigned in the DB
    }
    public ArrayList<Referee> RefereesToMakAsAssigned( ArrayList<Pair<Referee,Date>> assignedReferees) { // TODO CONNECT WITH DB
        //mark the referees as assigned in the DB
        return null;
    }
    public ArrayList<Pair<Date, Stadium>> getAvailableStadiums(){
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("select * from stadiums");
            ArrayList<Pair<Date, Stadium>> staduims_dates = new ArrayList<Pair<Date, Stadium>>();
            while(resultSet.next()){
                String string_date = resultSet.getString("date");
                String string_stadium = resultSet.getString("stadium");
                String string_city = resultSet.getString("city");

                Date date= new SimpleDateFormat("dd-MM-yyyy").parse(string_date);
                Stadium stadium = new Stadium(string_stadium, string_city);
                staduims_dates.add(new Pair<>(date, stadium));
            }

            return staduims_dates;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public HashMap<Date, ArrayList<Referee>> getAvailableReferrees(){
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("select * from referees");
            HashMap<Date, ArrayList<Referee>> referees_dates = new HashMap<Date, ArrayList<Referee>>();
            while(resultSet.next()){
                String string_date = resultSet.getString("date");
                String string_name = resultSet.getString("name");

                Date date= new SimpleDateFormat("dd-MM-yyyy").parse(string_date);
                Referee referee = new Referee(string_name);
                referees_dates.put(date, new ArrayList<Referee>());
            }
            return referees_dates;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<Date, ArrayList<Stadium>> getStadiumsAndDates(){ //TODO CONNECT WITH DB
        return new HashMap<Date, ArrayList<Stadium>>();
    }

    private DBConnector() {

    }

    public ArrayList<Referee> getRefereeByDate(Date date)
    {
        return null;
    }
    /**
     * Get a connection to database
     *
     * @return Connection object
     */
    /**
     * Test Connection
     */


}