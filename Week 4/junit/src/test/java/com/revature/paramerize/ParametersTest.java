package com.revature.paramerize;

/*
    If you ever need to run the same test with different inputs multiple times you can use the
    Parameterized class provided by Junit to do so. You create a method that returns a collection of
    your test data, create fields to store your test data information, and the each test in your class
    will execute a number of times equal to the number of data sets you defined

    This is very similar to how you would set up a Scenario Outline with Cucumber
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParametersTest {
    /*
        The method that returns your data collection should be annotated with @Parameters
        The fields of the class that will hold the test data should be annotated with @Parameter
     */

    @Parameter// defaults to first value in a data collection, index position 0
    public int numOne;
    @Parameter(1) // tells Junit to set the value of the field to the second element in a collection
    public int numTwo;
    @Parameter(2) // tells Junit to set the value of the field to the third element in a collection
    public int expectedSum;

    /*
        This method will return the data sets we need to use for our test
        The Collection returned should return a multi-dimensional array of all the data sets you
        need for your tests. Using Arrays.asList helps to simplify this process
     */
    @Parameters
    public static Collection<Integer[]> inputs(){
        return Arrays.asList(
                new Integer[][]{
                        {5,10,15},
                        {6,6,12},
                        {100,200,300},
                        {5,6,10}
                }
        );
    }

    @Test
    public void addition(){
        Assert.assertEquals(expectedSum, numOne + numTwo);
    }

    @Test
    public void extra(){
        System.out.println("How many times does this run?");
    }
}
