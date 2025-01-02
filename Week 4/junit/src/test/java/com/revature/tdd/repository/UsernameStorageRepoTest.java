package com.revature.tdd.repository;

import com.revature.exceptions.DuplicateUserException;
import com.revature.repository.UsernameStorageRepo;
import com.revature.repository.UsernameStorageRepoImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    A common naming convention when creating test classes is to add "Test" to the start or end of the
    test class name. This makes it easier to create patterns that can be detected by Junit to facilitate
    your tests
 */
public class UsernameStorageRepoTest {

    /*
        When creating your tests, unless you need some specific functionality from an implementation
        class, you should set the type of the class being tested to its interface/parent class. By doing
        this, it becomes much easier to switch what implementing class you are testing.
     */
    private UsernameStorageRepo usernameStorageRepo;
    private String positiveUsername;
    private String negativeUsername;
    private String duplicateUserExceptionMessage;

    @Before
    public void setup(){
        /*
            Not only does this setup method give us access to an
            object that can be used for testing, it also doubles
            as a "reset" for the "database" used to store usernames
            for our mini app

            Unless your test data is computationally expensive, or you must keep track of state between
            tests, you should default to resetting your test data after each test. This helps to prevent
            unintended failures when executing your tests due to the state of your test data being transformed
         */
        usernameStorageRepo = new UsernameStorageRepoImp();
        positiveUsername = "Robin";
        negativeUsername = "Batman";
        duplicateUserExceptionMessage = "Username taken: please choose another";
    }

    /*
        Based on the current requirements, there is not much test data needed:
        - Happy Path: any username will do as long as it is unique
            - test data: Robin, since name is not yet in database
        - Sad Path: a username already taken will work
            - test data: Batman inside of the database
     */

    @Test
    public void storeUsernamePositive(){
        String result = usernameStorageRepo.storeUsername(positiveUsername);
        /*
            Junit provides a class called "Assert" that contains a multitude of static methods for
            validating various conditions in your code. A very common option used is checking that
            the actual results of your method call match some expected value. Keep in mind whether
            you are interested in the content of the object or the object itself:
            - assertEquals checks content
            - assertSame checks if the objects are the same
         */
        Assert.assertEquals(positiveUsername, result);
    }

    @Test
    public void storeUsernameNegative(){
        try{
            // we expect this method call to throw an unhandled exception, so we don't need to save the results
            usernameStorageRepo.storeUsername(negativeUsername);
            Assert.fail("Expected DuplicateUserException, but no exception was thrown");
        } catch (DuplicateUserException e){
            Assert.assertEquals(duplicateUserExceptionMessage, e.getMessage());
        }

    }

}
