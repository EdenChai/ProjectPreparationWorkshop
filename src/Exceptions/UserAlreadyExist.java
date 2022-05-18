package Exceptions;

public class UserAlreadyExist extends Exception
{
    public UserAlreadyExist(String errorMessage)
    {
        super(errorMessage);
    }
}
