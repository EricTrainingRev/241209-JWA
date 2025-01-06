package com.revature.service;

import com.revature.dao.NameDAO;
import com.revature.exception.BillyDetectedException;
import com.revature.exception.DuplicateUsernameException;
import com.revature.exception.NameAdditionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
    In order to perform unit testing on the NameService object
    we can leverage Mockito to "fake" the resources used by
    the dependency NameDAO object. If we look at the NameDao
    class we will see it is only partially implemented: using it
    for integration testing would cause many tests to fail, not
    because the service (the thing we actually want to test) is
    incorrectly implement, but because the dependency is incomplete.
    Mockito allows us to perform our testing at the unit level without
    needing the dependency to even be implemented

    Key words:
    - mock: an object that can utilize resources of the "real" type
            that is being used, but we control the outputs of the object
            for testing purposes
    - stub: a method call with a pre-determined result
 */
public class NameServiceTest {

    private NameDAO nameDAO;
    private NameService nameService;

    private String positiveName;
    private String billy;
    private String duplicateName;

    private List<String> mockNameList;
    private List<String> duplicateNameList;

    @Before
    public void setup(){
        /*
            Instead of creating our nameDao directly we pass the class data to Mockito and Mockito
            will create a mocked version of the class that we can use to stub method calls and perform
            other state-based checks
         */
        nameDAO = Mockito.mock(NameDAO.class);
        nameService = new NameService(nameDAO);
        positiveName = "Sally";
        mockNameList = new ArrayList<>();
        mockNameList.add("Timmy");
        mockNameList.add("Betsy");
        billy = "billy";
        duplicateName = "Chuck";
        duplicateNameList = new ArrayList<>(mockNameList);
        duplicateNameList.add(duplicateName);
    }

    @Test
    public void positiveAddNameExceptForBilly(){
        /*
            When you need to stub a method you use the Mockito "when" method. As an argument you
            provide the following information:
            - mock object you are expecting your test method to interact with
            - method you want to stub from your mock object
            - any arguments that you expect to be passed to the stubbed method
            you provide this information like you are actually calling the stubbed method, don't
            provide them individually
         */
        /*
            here we tell our mock to return our mockNameList when returnNames is called in
            addNameExceptForBilly method execution
         */
        Mockito.when(nameDAO.returnNames()).thenReturn(mockNameList);
        /*
            here we tell our mock to return a true boolean when the addName method is called
            with the argument provided by the "positiveName" variable. Keep in mind this is specific:
            if we pass a different value to addName than the one we specify then we will not get our
            intended stub value returned
         */
        Mockito.when(nameDAO.addName(positiveName)).thenReturn(true);
        String result = nameService.addNameExceptForBilly(positiveName);
        Assert.assertEquals("Name added successfully", result);
    }

    @Test
    public void negativeAddNameExceptForBillyTryAddingBilly(){
        BillyDetectedException exception =  Assert.assertThrows(BillyDetectedException.class, () -> {nameService.addNameExceptForBilly(billy);});
        Assert.assertEquals("Billy is not allowed!", exception.getMessage());
    }

    @Test
    public void negativeAddNameExceptForBillyAddingDuplicateName(){
        Mockito.when(nameDAO.returnNames()).thenReturn(duplicateNameList);
        DuplicateUsernameException exception = Assert.assertThrows(DuplicateUsernameException.class, () -> {nameService.addNameExceptForBilly(duplicateName);});
        Assert.assertEquals("Name must be unique", exception.getMessage());
    }

    @Test
    public void negativeAddNameExceptForBillyNameFailsToAdd(){
        Mockito.when(nameDAO.returnNames()).thenReturn(mockNameList);
        // No need to mock the addNames method, because methods without stub info return their default value for their type
        NameAdditionException exception = Assert.assertThrows(NameAdditionException.class, () -> {nameService.addNameExceptForBilly(positiveName);});
        Assert.assertEquals("There was an issue adding the name to the database", exception.getMessage());
    }

    /*
        STANDALONE EXAMPLES
     */

    @Test
    public void mocksCanThrowExceptions(){
        Mockito.when(nameDAO.returnNames()).thenThrow(new BillyDetectedException("This would not normally happen, just showing for the example"));
        nameService.addNameExceptForBilly(positiveName);
    }

    /*
        Anytime you need to gather state information about your mock test objects (this can be for
        gathering stakeholder metrics, validating requirements for regulators, meeting internal
        auxiliary requirements, etc.) you can test the state of the mock object itself. The main
        way of doing this is through the use of Mockito's "verify" method
     */
    @Test
    public void validateStateOfMock(){
        Mockito.when(nameDAO.returnNames()).thenReturn(mockNameList);
        Mockito.when(nameDAO.addName(Mockito.anyString())).thenReturn(true);
        nameService.addNameExceptForBilly(positiveName);
        /*
            The code below checks that our mock object called the addName method with the argument
            provided by positiveName one time. If not an exception is thrown and the test will
            fail
         */
        Mockito.verify(nameDAO).addName(positiveName);
    }


}
