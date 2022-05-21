package Exceptions;

public class UserNameInvalid extends Exception
{
    public UserNameInvalid(String errorMessage)
    {
        super(errorMessage);
    }
}
