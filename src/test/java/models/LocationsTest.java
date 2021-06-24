package models;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationsTest  {

    @Test
    public void locationsCreateInstanceOfLocation(){
        Locations testLocation = new Locations("Nairobi-Mombasa",1000);
        assertEquals(true,testLocation instanceof Locations);
    }

    @Test
    public void allLocationsAreSaved(){
        Locations testLocation = new Locations("Nairobi-Nakuru",700);
        testLocation.save();
        assertEquals(1,Locations.all().size());
    }

    @Test
    public void locationCreatedDeleteByIdDeleteCorrectly(){
        Locations testLocation = new Locations("Nakuru-Eldoret",500);
        testLocation.save();
        testLocation.deleteById();
        assertEquals(0,Users.all().size());
    }

    @Test
    public void locationFoundById(){
        Locations testLocation = new Locations("Eldoret-Nairobi",1500);
        testLocation.save();
        Locations otherLocation = new Locations("Nairobi-Eldoret",1500);
        otherLocation.save();
        Locations foundLocation = Locations.find(testLocation.getId());
    }

    @Test
    public void deleteAllLocation(){
        Locations testLocation = new Locations("Nakuru-Mombasa",2700);
        testLocation.save();
        testLocation.delete();
        assertEquals(0,Locations.all().size());
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}