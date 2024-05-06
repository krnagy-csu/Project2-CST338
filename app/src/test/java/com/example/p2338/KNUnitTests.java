package com.example.p2338;

import com.example.p2338.Database.Entities.TierList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KNUnitTests {
    private TierList tierList;

    @Before
    public void setUp() {
        tierList = new TierList("S", "A", "B", "C", "D", "F");
    }

    @Test
    public void testGettersAndSetters() {
        tierList.setTlID(1);
        assertEquals(1, tierList.getTlID());

        tierList.setUserID(2);
        assertEquals(2, tierList.getUserID());

        tierList.setTierS("S+");
        assertEquals("S+", tierList.getTierS());

        tierList.setTierA("A+");
        assertEquals("A+", tierList.getTierA());

        tierList.setTierB("B+");
        assertEquals("B+", tierList.getTierB());

        tierList.setTierC("C+");
        assertEquals("C+", tierList.getTierC());

        tierList.setTierD("D+");
        assertEquals("D+", tierList.getTierD());

        tierList.setTierF("F+");
        assertEquals("F+", tierList.getTierF());

        tierList.setTopic("Food");
        assertEquals("Food",tierList.getTopic());
    }

    @Test
    public void testEquals() {
        TierList tierList2 = new TierList("S", "A", "B", "C", "D", "F");
        tierList2.setTlID(1);
        tierList2.setUserID(2);

        assertTrue(tierList.equals(tierList2));
    }
}