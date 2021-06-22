package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RatingsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void Ratings_instantiatesCorrectly_true(){
        Ratings testratings = new Ratings("maalim","The journey had good music",5);
        assertEquals(true, testratings instanceof Ratings);
    }

    @Test
    public void savedRatingsInDatabase(){
        Ratings testratings = new Ratings("maalim","The journey had good music",0);
        testratings.save();

        Ratings savedRatings = Ratings.all().get(0);
        assertEquals(testratings.getId(),savedRatings.getId());
    }

    @Test
    public void returnsNameOfDriver(){
        Users testUser = new Users("User One","0712345678","Nairobi-Mombasa","Driver A",1000);
        testUser.save();

        Ratings testratings = new Ratings(testUser.getDriver_name(),"The journey had good music",5);
        testratings.save();

        assertEquals("Driver A", testUser.getDriver_name());
    }


    //user deleted by id
    @Test
    public void userCreatedDeleteByIdDeleteCorrectly(){
        Users testUser = new Users("User One","0712345678","Nairobi-Mombasa","Driver A",1000);
        testUser.save();

        Ratings testratings = new Ratings(testUser.getDriver_name(),"The journey had good music",5);
        testratings.save();

        testratings.deleteById();
        assertEquals(0,Ratings.all().size());
    }



}