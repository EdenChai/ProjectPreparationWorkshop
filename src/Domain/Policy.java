package Domain;

import Domain.Users.Referee;

public class Policy {





    public Boolean IsGameLegal(Game game){
        return(true);
    }
    public Boolean IsRefereeLegal(Game game, Referee referee){
        return(true);
    }
}
