package com.revature.repository;

import com.revature.planetarium.entities.User;
import com.revature.planetarium.repository.user.UserDao;
import com.revature.planetarium.repository.user.UserDaoImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class UserDaoPositiveTest extends UserDaoTest {

    private User positiveUser;

    @Before
    public void positiveSetup(){
        positiveUser = new User(0, "Super_man-2001", "Krypton-was_2000");
    }

    @Test
    public void createUserPositiveTest(){
        Optional<User> response = userDao.createUser(positiveUser);
        Assert.assertTrue(response.isPresent());
        Assert.assertNotEquals(0, response.get().getId());
    }

}
