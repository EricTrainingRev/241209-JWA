package com.revature.repository;

import com.revature.planetarium.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class UserDaoFindUserByUsernameNegativeTest extends UserDaoTest {

    private String negativeUsername;

    @Before
    public void negativeSetup(){
        negativeUsername = "Joker";
    }

    @Test
    public void findUserByUsernameNegativeTest(){
        Optional<User> result = userDao.findUserByUsername(negativeUsername);
        Assert.assertFalse(result.isPresent());
    }

}
