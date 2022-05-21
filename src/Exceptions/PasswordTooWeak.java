package Exceptions;

public class PasswordTooWeak extends Exception
{
    public PasswordTooWeak(String errorMessage)
    {
        super(errorMessage);
    }
}
