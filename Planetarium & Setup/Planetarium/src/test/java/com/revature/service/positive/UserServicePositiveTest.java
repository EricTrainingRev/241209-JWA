package com.revature.service.positive;

import com.revature.planetarium.entities.User;
import com.revature.service.parent.UserServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class UserServicePositiveTest extends UserServiceTest {

    private User positiveUser;
    private Optional<User> mockOptional;
    private User mockReturnedUser;
    private String createUserSuccessMessage;

    private User positiveAuthenticateCredentials;
    private Optional<User> authenticateUserOptional;
    private User positiveAuthenticateUser;
    private User expectedAuthenticateResult;

    @Before
    public void positiveSetup(){
        positiveUser = new User(0, "Super_man-2001", "Krypton-was_2000");
        mockReturnedUser = new User(2,"Super_man-2001", "Krypton-was_2000");
        mockOptional = Optional.of(mockReturnedUser);
        createUserSuccessMessage = "User created successfully";
        positiveAuthenticateCredentials = new User(0,"Batman","Iamthenight1939");
        positiveAuthenticateUser = new User(1,"Batman","Iamthenight1939");
        authenticateUserOptional = Optional.of(positiveAuthenticateUser);
        expectedAuthenticateResult = new User();
        expectedAuthenticateResult.setId(1);
        expectedAuthenticateResult.setUsername("Batman");
    }


    @Test
    public void serviceCreateUserPositiveTest(){
        Mockito.when(userDao.createUser(positiveUser)).thenReturn(mockOptional);
        String result = userService.createUser(positiveUser);
        Assert.assertEquals(createUserSuccessMessage, result);
    }

    @Test
    public void serviceAuthenticatePositiveTest(){
        Mockito.when(userDao.findUserByUsername(positiveAuthenticateCredentials.getUsername())).thenReturn(authenticateUserOptional);
        User result = userService.authenticate(positiveAuthenticateCredentials);
        Assert.assertEquals(expectedAuthenticateResult, result);
    }

}
