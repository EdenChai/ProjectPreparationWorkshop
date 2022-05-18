package UnitTesting;

import Domain.Users.Fan;
import Domain.Users.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static java.time.Duration.ofSeconds;
import static java.time.Duration.ofMinutes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

/**
 * assertEquals
 * assertEquals(4, calculator.multiply(2, 2),"optional failure message");
 *
 * assertTrue
 * assertTrue('a' < 'b', () → "optional failure message");
 *
 * assertFalse
 * assertFalse('a' > 'b', () → "optional failure message");
 *
 * assertNotNull
 * assertNotNull(yourObject, "optional failure message");
 *
 * assertNull
 * assertNull(yourObject, "optional failure message");
 */


class UnitTestingExample
{
    User user;

    @BeforeEach
    void setUp()
    {

    }


    @Test
    @DisplayName("Logging in the user")
    void demoTestMethod() {
        assertTrue(true,"Should log in the valid user");
    }

    @RepeatedTest(5)
    void demoTestMethod2() {
        assertTrue(true,"Should log in the valid user");
    }

    @Test
    void exceptionTesting() {
        // set up user

    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(ofMinutes(1), () -> user.logOut());
    }



}
