package com.revature.repository.negative;

import com.revature.planetarium.entities.User;
import com.revature.planetarium.exceptions.UserFail;
import com.revature.repository.parent.UserDaoTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import  static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class UserDaoCreateUserNegativeTest extends UserDaoTest {

    @Parameter
    public int userId;

    @Parameter(1)
    public String username;

    @Parameter(2)
    public String password;

    @Parameter(3)
    public String exceptionMessage;

    /*
        You can hardcode your test values, but for a longer list like this you would probably be better
        off in the long run loading your test data from a file (like a csv) and creating your arrays
        of data that way
     */
    @Parameters
    public static Collection<Object> inputs(){
        return Arrays.asList(new Object[][]{
                {0,"Batman","Krypton-was_2000","Invalid username"},
                {0,"Bane","Krypton-was_2000","Invalid username"},
                {0,"wonder_woman_for_the_DC_theming","Krypton-was_2000","Invalid username"},
                {0,"2face","Krypton-was_2000","Invalid username"},
                {0,"joker!!!!!!?)","Krypton-was_2000","Invalid username"},
                {0,"Super_man-2001","b0Ts","Invalid password"},
                {0,"Super_man-2001","AlfredIsTheBestButlerToExist111","Invalid password"},
                {0,"Super_man-2001","3atman","Invalid password"},
                {0,"Super_man-2001","A1fredIsTheBestButlerToExist!!","Invalid password"},
                {0,"Super_man-2001","batman1","Invalid password"},
                {0,"Super_man-2001","BATMAN1","Invalid password"},
                {0,"Super_man-2001","Robin","Invalid password"},
        });
    }

    /*
        NOTE: this is considered 1 test for the purpose of the @Before
        setup method in the parent test class: the database will be
        reset, and then the test method below will run for each collection
        of test data in the inputs method above
     */
    @Test
    public void createUserNegativeTest(){
        User testUser = new User(userId, username, password);
        UserFail exception = Assert.assertThrows(UserFail.class, ()-> {userDao.createUser(testUser);});
        Assert.assertEquals(exceptionMessage, exception.getMessage());
    }

}
