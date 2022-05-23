package Exceptions;

public class AssignGameByDifferentUser extends Exception{
    public  AssignGameByDifferentUser(String errorMessage)
    {
        super(errorMessage);
    }
}

