package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DriversTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void driverChosenInstantiatesCorrectly(){
        Drivers driver = SetUpDrivers();
        assertEquals(true,driver instanceof Drivers);
    }

    //driver is saved
    @Test
    public void driverIsSaved(){
        Drivers testDriver = SetUpDrivers();
        testDriver.save();
        assertEquals(1,Drivers.all().size());
    }

    //driver is deleted by id
    @Test
    public void driverChosenIsDeletedByIdCorrectly(){
        Drivers testDrivers = SetUpDrivers();
        testDrivers.save();
        testDrivers.deleteById();
        assertEquals(0,Drivers.all().size());
    }

    @Test
    public void driverChosenDeleteIsReturnedCorrectly(){
        Drivers testDrivers = SetUpDrivers();
        Drivers otherDrivers = SetUpDrivers();
        testDrivers.save();
        otherDrivers.save();
        testDrivers.delete();
        assertEquals(0,Drivers.all().size());
    }

    @Test
    public void findDriversById(){
        Drivers testDrivers = SetUpDrivers();
        Drivers otherTest = SetUpDrivers();
        testDrivers.save();
        otherTest.save();
        Drivers foundDrivers = Drivers.find(testDrivers.getId());
    }

    public Drivers SetUpDrivers() {
        return new Drivers("Driver one");
    }
}
