package com.revature.repository;

import com.revature.planetarium.repository.user.UserDao;
import com.revature.planetarium.repository.user.UserDaoImp;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import  static org.junit.runners.Parameterized.*;
@RunWith(Parameterized.class)
public class UserDaoNegativeTest {

    private UserDao userDao;

    @Parameter
    private int userId;

    @Parameter(1)
    private String username;

    @Parameter(2)
    private String password;

    @Parameter(3)
    private String exceptionMessage;

    @Parameters
    public Collection<Object> inputs(){
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
    public void setup(){
        userDao = new UserDaoImp();
    }

}
