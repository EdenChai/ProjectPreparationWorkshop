package DataAccess;

import Domain.Stadium;
import Domain.Users.Referee;
import Domain.Users.User;
import Exceptions.UserAlreadyExist;
import Exceptions.UserDoesNotExist;
import javafx.util.Pair;

//import java.sql.*;
//import java.sql.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;

public class DBConnector {
    String URL = "jdbc:mysql://localhost:3306/assignment3_db";
    String USER = "root";
    String PASS = "Arnon1";
    Connection connection;


    private Statement statement;
    private static DBConnector instance;



    public DBConnector()
    {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3_db", "root", "Arnon1");
            this.statement = connection.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    //private constructor to avoid client applications to use constructor
    public static DBConnector getInstance(){
        if (instance == null){
            instance = new DBConnector();
        }
        return instance;
    }

    public void DatesAndStadiumsToMakeAsAssigned(ArrayList<Pair<Date, Stadium>>  datesAndStadiums){ // TODO CONNECT WITH DB
        //mark the referees as assigned in the DB
        ResultSet resultSet = null;
        try {
            for (int i = 0; i < datesAndStadiums.size(); i++) {
                Date date = datesAndStadiums.get(i).getKey();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String strDate = dateFormat.format(date);
                String strStadium = datesAndStadiums.get(i).getValue().getName();
                //System.out.println(strStadium);

                String query = "DELETE FROM stadiums WHERE date= '" + strDate + "' AND stadium= '" + strStadium + "'";
                statement.executeUpdate(query);
                System.out.println(strDate + strStadium);
                //System.out.println("Record deleted successfully");
            }

            return ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
    public HashMap<Date, ArrayList<Referee>> getAvailableReferees(){
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("select * from referees");
            HashMap<Date, ArrayList<Referee>> referees_dates = new HashMap<Date, ArrayList<Referee>>();
            while(resultSet.next()){
                String string_date = resultSet.getString("date");
                String string_name = resultSet.getString("name");

                Date date= new SimpleDateFormat("dd-MM-yyyy").parse(string_date);
                //Referee referee = new Referee(string_name);
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


    /**
     * Get a connection to database
     *
     * @return Connection object
     */
    /**
     * Test Connection
     */


    /**
     Functions for Arie and Eden for Login user case, basic user manipulations
     */

    public User getUser(String mail) throws UserDoesNotExist
    {
        return null; // TODO
    }

    //region Outdated

//    public void removeUser(String mail)  throws UserDoesNotExist
//    {
//        // TODO
//    }
//
//    public void addUser(User user, String type) throws UserAlreadyExist
//    {
//        // TODO
//    }
//
//    public void updateUser(String mail, User user, String type) throws UserDoesNotExist, UserAlreadyExist
//    {
//        removeUser(mail);
//        addUser(user, type);
//    }

    //endregion




}