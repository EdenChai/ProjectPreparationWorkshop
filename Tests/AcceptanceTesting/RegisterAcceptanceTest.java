package AcceptanceTesting;

import DataAccess.DBConnector;
import Domain.Users.Fan;
import Domain.Users.User;
import Service.System;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Exceptions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegisterAcceptanceTest
{
//    DBConnector dbConnector;
//    System system;
//
//    @BeforeEach
//    void setUp()
//    {
//        dbConnector = new DBConnector();
//        system = new System(dbConnector);
//    }
//
//    @AfterEach
//    void tearDown()
//    {
//        try
//        {
//            dbConnector.removeUser("validname");
//        }
//        catch (UserDoesNotExist e)
//        {
//            ;
//        }
//    }
//
//    @Test
//    @DisplayName("A.Register.1 - success function test")
//    void success()
//    {
//        User user = null;
//        assertDoesNotThrow(()-> system.registerFan("validname", "HardPass#@!", false, system));
//        try
//        {
//            user = dbConnector.getUser("validname");
//        }
//        catch (UserDoesNotExist e)
//        {
//            fail("User doesn't exist");
//        }
//        assertTrue(user instanceof Fan);
//        assertFalse(user.isLogged());
//    }
//
//    @Test
//    @DisplayName("A.Register.2 - passwordTooWeak function test")
//    void passwordTooWeak()
//    {
//        assertThrows(PasswordTooWeak.class,()-> system.registerFan("validname", "password", false, system));
//        assertThrows(UserDoesNotExist.class, ()-> dbConnector.getUser("validname"));
//    }
//
//    @Test
//    @DisplayName("A.Register.3 - userExist function test")
//    void userExist()
//    {
//        assertDoesNotThrow(()-> system.registerFan("validname", "HardPass#@!", false, system));
//        assertThrows(UserAlreadyExist.class,()-> system.registerFan("validname", "HardPass#@!", false, system));
//    }
//
//    @Test
//    @DisplayName("A.Register.4 - IllegalUserName test")
//    void IllegalUserName()
//    {
//        assertThrows(UserNameInvalid.class,()-> system.registerFan("שםלאחוקי", "HardPass#@!", false, system));
//    }
}
