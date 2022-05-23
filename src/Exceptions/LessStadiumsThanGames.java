package Exceptions;

public class LessStadiumsThanGames extends Exception
{
    public LessStadiumsThanGames(String errorMessage)
    {
        super(errorMessage);
    }
}
