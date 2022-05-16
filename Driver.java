package DataAccess;

import Domain.Stadium;
import javafx.util.Pair;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Driver {
    public static void main(String[] args) {

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3_db", "root", "Arnon1");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from stadiums");
            ArrayList<Pair<Date, Stadium>> staduims_dates = new ArrayList<Pair<Date, Stadium>>();
            while(resultSet.next()){
                String string_date = resultSet.getString("date");
                String string_stadium = resultSet.getString("stadium");
                String string_city = resultSet.getString("city");

                Date date= new SimpleDateFormat("dd-MM-yyyy").parse(string_date);
                Stadium stadium = new Stadium(string_stadium, string_city);
                staduims_dates.add(new Pair<>(date, stadium));
            }

            System.out.println(staduims_dates.get(0));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
