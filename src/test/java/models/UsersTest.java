package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void userCreatedInstantiatesCorrectWithUser(){
        Users users = SetUpUser();
        assertEquals(true,users instanceof Users);
    }

    //user is saved
    @Test
    public void userCreatedIsSaved(){
        Users testUser = SetUpUser();
        testUser.save();
        assertEquals(1,Users.all().size());
    }

    //user deleted by id
    @Test
    public void userCreatedDeleteByIdDeleteCorrectly(){
        Users testUser = SetUpUser();
        testUser.save();
        testUser.deleteById();
        assertEquals(0,Users.all().size());
    }

    @Test
    public void userCreatedDeleteIsReturnedCorrectly(){
        Users testUser = SetUpUser();
        Users otherUser = SetUpUser();
        testUser.save();
        otherUser.save();
        testUser.delete();
        assertEquals(0,Users.all().size());
    }

    @Test
    public void findUserById(){
        Users testUser = SetUpUser();
        Users otherTest = SetUpUser();
        testUser.save();
        otherTest.save();
        Users foundUser = Users.find(testUser.getId());
    }

    public Users SetUpUser() {
        return new Users("User One","0712345678","Nairobi-Mombasa","Driver A",1000);
    }
}