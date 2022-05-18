package Exceptions;

public class UserDoesNotExist extends Exception
{
    public UserDoesNotExist(String errorMessage)
    {
        super(errorMessage);
    }
}
