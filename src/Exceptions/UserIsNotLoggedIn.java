package Exceptions;

public class UserIsNotLoggedIn extends Exception
{
    public UserIsNotLoggedIn(String errorMessage)
    {
        super(errorMessage);
    }
}
