package Exceptions;

public class UserPasswordDoesNotMatch extends Exception
{
    public UserPasswordDoesNotMatch(String errorMessage)
    {
        super(errorMessage);
    }
}
