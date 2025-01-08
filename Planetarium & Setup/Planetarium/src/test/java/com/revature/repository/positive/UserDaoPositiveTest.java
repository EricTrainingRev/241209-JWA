package com.revature.repository.positive;

import com.revature.planetarium.entities.User;
import com.revature.repository.parent.UserDaoTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class UserDaoPositiveTest extends UserDaoTest {

    private User positiveUser;
    private String positiveUsername;

    @Before
    public void positiveSetup(){
        positiveUser = new User(0, "Super_man-2001", "Krypton-was_2000");
        positiveUsername = "Batman";
    }

    @Test
    public void createUserPositiveTest(){
        Optional<User> response = userDao.createUser(positiveUser);
        Assert.assertTrue(response.isPresent());
        Assert.assertNotEquals(0, response.get().getId());
    }

    @Test
    public void findUserByUsernamePositiveTest(){
        Optional<User> result = userDao.findUserByUsername(positiveUsername);
        Assert.assertTrue(result.isPresent());
    }

}
