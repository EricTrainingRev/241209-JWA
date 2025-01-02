package com.revature.paramerize;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DifferentTypesTest {

    /*
        If you need different types of data for your parameterized tests keep it simple and make
        your multidimensional array for Objects. This will let you put in whatever data you need
     */
    @Parameterized.Parameters
    public static Collection<Object[]> inputs(){
        return Arrays.asList(
                new Object[][]{
                        {"valid", "valid", true},
                        {"invalid","valid",false}
                }
        );
    }

    @Parameterized.Parameter
    public String username;
    @Parameterized.Parameter(1)
    public String password;
    @Parameterized.Parameter(2)
    public boolean isValid;

    @Test
    public void testLogin(){
        System.out.println(username);
        System.out.println(password);
        System.out.println(isValid);
        /*
            Example of how you might use this data:
                boolean result = service.login(username, password);
                Assert.assertEquals(isValid, result);
         */

    }

}
