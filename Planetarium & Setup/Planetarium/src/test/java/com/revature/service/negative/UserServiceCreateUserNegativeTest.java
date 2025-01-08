package com.revature.service.negative;

import com.revature.planetarium.entities.User;
import com.revature.planetarium.exceptions.UserFail;
import com.revature.service.parent.UserServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UserServiceCreateUserNegativeTest extends UserServiceTest {

    private User negativeUser;

    @Parameter
    public int userId;

    @Parameter(1)
    public String username;

    @Parameter(2)
    public String password;

    @Parameter(3)
    public String expectedExceptionMessage;

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

    @Before
    public void negativeSetup(){
        negativeUser = new User(userId, username, password);
    }


    @Test
    public void createUserNegativeTest(){
        Mockito.when(userDao.createUser(negativeUser)).thenThrow(new AssertionError("UserFail exception expected, but it was not thrown when it should have been"));
        UserFail userFail = Assert.assertThrows(UserFail.class, ()->{userService.createUser(negativeUser);});
        Assert.assertEquals(expectedExceptionMessage, userFail.getMessage());
    }

}
