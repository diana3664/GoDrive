package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RatingsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void monster_instantiatesCorrectly_true(){
        Ratings testratings = new Ratings ("Bubbles", "There was good music",5);
        assertEquals(true, testratings instanceof Ratings);
    }
}