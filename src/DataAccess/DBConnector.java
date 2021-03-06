package DataAccess;

import Domain.Stadium;
import Domain.Users.*;
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
                //System.out.println(strDate + strStadium);
                //System.out.println("Record deleted successfully");
            }

            return ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void RefereesToMakAsAssigned( ArrayList<Pair<Referee,Date>> assignedReferees) { // TODO CONNECT WITH DB
        //mark the referees as assigned in the DB
        ResultSet resultSet = null;
        try {
            for (int i = 0; i < assignedReferees.size(); i++) {
                Date date = assignedReferees.get(i).getValue();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String strDate = dateFormat.format(date);
                String strReferees = assignedReferees.get(i).getKey().getUserName();

                String query = "DELETE FROM referees WHERE date= '" + strDate + "' AND name= '" + strReferees + "'";
                statement.executeUpdate(query);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
                User user = getUser(string_name);
                Referee referee = new Referee(user.getUserName(), user.getPassword(), user.isLogged());
                if (!referees_dates.containsKey(date)) {
                    referees_dates.put(date, new ArrayList<Referee>());
                }
                referees_dates.get(date).add(referee);
            }
            return referees_dates;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (UserDoesNotExist e) {
            throw new RuntimeException(e);
        }
    }

    /**
     basic user manipulations
     */

    public User getUser(String username) throws UserDoesNotExist {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("select * from users where username='" + username + "'");
            //HashMap<Date, ArrayList<Referee>> referees_dates = new HashMap<Date, ArrayList<Referee>>();
            String string_username = null;
            String string_password = null;
            String string_isLogged = null;
            String string_type = null;
            boolean isLogged = false;
            while(resultSet.next()) {
                string_username = resultSet.getString("username");
                string_password = resultSet.getString("password");
                string_isLogged = resultSet.getString("isLogged");
                string_type = resultSet.getString("type");
                //System.out.println(isLogged);
                if (string_isLogged == "1"){
                    isLogged = true;
                }
            }
            User user = null;
            if (string_type.equals("AssociationMember")){
                user = new AssociationMember(string_username, string_password, isLogged);
            } else if (string_type.equals("Coach")){
                user = new Coach(string_username, string_password, isLogged);
            } else if (string_type.equals("Fan")){
                user = new Fan(string_username, string_password, isLogged);
            } else if (string_type.equals("MainReferee")){
                user = new MainReferee(string_username, string_password, isLogged);
            } else if (string_type.equals("Player")){
                user = new Player(string_username, string_password, isLogged);
            } else if (string_type.equals("Referee") ){
                user = new Referee(string_username, string_password, isLogged);
            } else if (string_type.equals( "SystemManager")){
                user = new SystemManager(string_username, string_password, isLogged);
            } else if (string_type.equals("TeamManager")){
                user = new TeamManager(string_username, string_password, isLogged);
            } else if (string_type.equals("TeamOwner")){
                user = new TeamOwner(string_username, string_password, isLogged);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new UserDoesNotExist("user does not exist");
        }
    }

    public void removeUser(String username)  throws UserDoesNotExist
    {
        ResultSet resultSet = null;
        try {
            String query = "DELETE FROM users WHERE username= '" + username + "'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(User user, String type) throws UserAlreadyExist
    {
        ResultSet resultSet = null;
        String username = user.getUserName();
        String password = user.getPassword();
        boolean isLogged = user.isLogged();
        try {
            String query = "INSERT INTO `assignment3_db`.`users`\n" +
                    "(`username`,\n" +
                    "`password`,\n" +
                    "`isLogged`,\n" +
                    "`type`)\n" +
                    "VALUES\n" +
                    "('"+username+"',\n" +
                    "'"+password+"',\n" +
                    isLogged + ",\n" +
                    "'"+ type +"');";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(String mail, User user, String type) throws UserDoesNotExist, UserAlreadyExist
    {
        removeUser(mail);
        addUser(user, type);
    }

    /**
     basic referee-date manipulations
     */

    public void removeRefereeDate(String username, Date date)  throws UserDoesNotExist
    {
        ResultSet resultSet = null;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(date);
        try {
            String query = "DELETE FROM referees WHERE name='" + username + "' AND date='" + strDate + "'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addRefereeDate(Referee user, Date date) throws UserAlreadyExist
    {
        ResultSet resultSet = null;
        String username = user.getUserName();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(date);
        addUser(user, "Referee");
        try {
            String query = "INSERT INTO `assignment3_db`.`referees`\n" +
                    "(`date`,\n" +
                    "`name`)\n" +
                    "VALUES\n" +
                    "('"+ strDate +"',\n" +
                    "'"+username+"');";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateRefereeDate(Referee user, Date date, Date newDate) throws UserDoesNotExist, UserAlreadyExist
    {
        removeRefereeDate(user.getUserName(), date);
        addRefereeDate(user, newDate);
    }

    /**
     basic stadium-date manipulations
     */

    public void removeStadiumDate(String name, Date date)  throws UserDoesNotExist
    {
        ResultSet resultSet = null;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(date);
        try {
            String query = "DELETE FROM stadiums WHERE stadium= '" + name + "' and date='" + strDate + "'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addStadiumDate(Stadium stadium, Date date) throws UserAlreadyExist
    {
        ResultSet resultSet = null;
        String username = stadium.getName();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(date);
        String city = stadium.getCity();

        try {
            String query = "INSERT INTO `assignment3_db`.`stadiums`\n" +
                    "(`stadium`,\n" +
                    "`date`,\n" +
                    "`city`)\n" +
                    "VALUES\n" +
                    "('" +username+"',\n'" +
                    strDate +"',\n'" +
                    city + "');";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStadiumDate(Stadium stadium, Date date, String city, Date newDate, String newCity) throws UserDoesNotExist, UserAlreadyExist
    {
        removeStadiumDate(stadium.getName(), date);
        addStadiumDate(stadium, newDate);
    }

    public void eraseDBContent(){
        try {
            String query = "delete from users";
            statement.executeUpdate(query);
            query = "delete from referees";
            statement.executeUpdate(query);
            query = "delete from stadiums";
            statement.executeUpdate(query);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}