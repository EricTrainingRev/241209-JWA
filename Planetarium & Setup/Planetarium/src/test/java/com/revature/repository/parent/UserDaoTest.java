package com.revature.repository.parent;

import com.revature.planetarium.repository.user.UserDao;
import com.revature.planetarium.repository.user.UserDaoImp;
import com.revature.util.Setup;
import org.junit.Before;

public class UserDaoTest {

    protected UserDao userDao;

    @Before
    public void setup(){
        userDao = new UserDaoImp();
        Setup.resetTestDatabase();
    }

}
