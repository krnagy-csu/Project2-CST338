package com.example.p2338;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;
import Database.Entities.User;

public class UserTest {

    @Test
    public void testSetters() {
        // Test if the setter methods initialize the user object correctly
        User user = new User();
        user.setUsername("bob");
        user.setPassword("acoolpassword123");
        user.setAdmin(false);
        assertEquals("bob", user.getUsername());
        assertEquals("acoolpassword123", user.getPassword());
        assertFalse(user.getAdmin());
        assertNull(user.getPoints());
        assertNull("", user.getPurchases());
    }

    @Test
    public void testEquals() {
        // Test if creating two user objects with the same attributes are seen as equal
        User user1 = new User();
        user1.setUsername("bob");
        user1.setPassword("acoolpassword123");
        user1.setAdmin(false);
        // Create another user just to make sure
        User user2 = new User();
        user2.setUsername("bob");
        user2.setPassword("acoolpassword123");
        user2.setAdmin(false);
        // Are they equal though
        assertEquals(user1.getUsername(), user2.getUsername());
        assertEquals(user1.getPassword(), user2.getPassword());
        assertEquals(user1.getAdmin(), user2.getAdmin());
    }
}
