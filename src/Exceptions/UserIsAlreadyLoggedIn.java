package Exceptions;

public class UserIsAlreadyLoggedIn extends Exception
{
    public UserIsAlreadyLoggedIn(String errorMessage)
    {
        super(errorMessage);
    }

}
