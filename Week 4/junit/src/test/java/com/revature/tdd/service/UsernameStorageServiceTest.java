package com.revature.tdd.service;

import com.revature.exceptions.DuplicateUserException;
import com.revature.repository.UsernameStorageRepo;
import com.revature.repository.UsernameStorageRepoImp;
import com.revature.service.UsernameStorageService;
import com.revature.service.UsernameStorageServiceImp;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class UsernameStorageServiceTest {

    /*
        Because our service layer needs to pass information to the repo layer, we need to have
        a repo object that the service can use for sending information to the repo layer and retrieving
        information from it as well. This is an example of integration testing: both the repo and service
        objects must be working correctly in order for our tests to pass
     */
    private UsernameStorageRepo usernameStorageRepo;
    private UsernameStorageService usernameStorageService;
    private String positiveUsername;
    private String negativeUsername;
    private String successMessage;
    private String exceptionMessage;

    @Before
    public void setup(){
        usernameStorageRepo = new UsernameStorageRepoImp();
        usernameStorageService = new UsernameStorageServiceImp(usernameStorageRepo);
        positiveUsername = "Robin";
        negativeUsername = "Batman";
        successMessage = positiveUsername + " added to database successfully";
        exceptionMessage = "Username taken: please choose another";
    }

    @Test
    public void storeUsernamePositive(){
        // keep in mind: this is an integration test, so if the repo is not working correctly this will fail
        String result = usernameStorageService.storeUsername(positiveUsername);
        // using a static import makes the assertion statement read a little cleaner
        assertEquals(successMessage, result);
    }

    @Test
    public void storeUsernameNegative(){
        /*
            The more common way of testing for exceptions is to use the assertThrows method: this method
            returns a Throwable, which you typically will specify as the Exception you are expecting to
            be thrown. If you need to perform any checks on the exception you save the value to a variable,
            but if you are just checking that the exception is thrown you can leave that off.

            The assertThrows method takes two argument minimum:
            - expectedThrowable: this is the exception you are expecting to be thrown unhandled
            -runnable: this is the method that is expected to throw your exception. It is wrapped inside of
                       a lambda so that it can be executed and returned via the assertThrows method
         */
        DuplicateUserException result = assertThrows(
                // expected exception
                DuplicateUserException.class,
                // runnable that should cause the expected exception to be thrown
                () -> {
                    usernameStorageService.storeUsername(negativeUsername);
                }
            );
        assertEquals(exceptionMessage, result.getMessage());
    }

    @Test
    public void exceptionTestingVerbose(){
        ThrowingRunnable runnable = () -> {
          usernameStorageService.storeUsername(negativeUsername);
        };
        DuplicateUserException result = assertThrows(DuplicateUserException.class,runnable);
        assertEquals(exceptionMessage, result.getMessage());
    }

}
