package Domain;

import java.util.ArrayList;

/**
 * @author Eden_Hai
 * @version 1.0
 * @since 02-05-2022
 */
public class Stadium
{
   private ArrayList<Game> games;
   private String name;
   private String city;

   public Stadium(String name, String city) {
      this.games = new ArrayList<Game>();
      this.name = name;
      this.city = city;
   }

   @Override
   public String toString() {
      return "Stadium{" +
              "games=" + games +
              ", name='" + name + '\'' +
              ", city='" + city + '\'' +
              '}';
   }

   public void addGame(Game game){
      this.games.add(game);
   }

   public String getName() {
      return name;
   }

   public String getCity() {
      return city;
   }
}
