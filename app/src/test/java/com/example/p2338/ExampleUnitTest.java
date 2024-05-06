package com.example.p2338;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import com.example.p2338.Database.Project2Repository;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Project2Repository repo;
    @BeforeEach
    void setup(){
        repo = Project2Repository.getRepository();
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


}