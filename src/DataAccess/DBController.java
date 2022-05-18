package DataAccess;

import Domain.Users.*;
import Exceptions.UserDoesNotExist;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DBController implements  Dao
{

    /** -----User log in scenario----- */

    private DB db;

    @Override
    public Optional get(long id)
    {
        return Optional.empty();
    }

    @Override
    public List getAll()
    {
        return null;
    }

    @Override
    public void save(Object o) throws SQLException
    {

    }

    @Override
    public void update(Object o, String[] params)
    {

    }

    @Override
    public void delete(Object o)
    {

    }


    public User getUser(String email) throws Exception
    {
        //TODO - For DB maker
        User user = db.getUser(email);

        if (user == null)
        {
            // If User doesn't exist
            throw new UserDoesNotExist("No such user exist in the system");
        }
        // If User exist, return it
        return user;
    }

    public void addUser(User newUser, String type)
    {
        //TODO - For DB maker
    }


    public void removeUser(String userToRemove)
    {
        //TODO - For DB maker
    }

    public void updateUser(String email,User updatedUser, String type)
    {
        removeUser(email);
        addUser(updatedUser, type);

    }




}
