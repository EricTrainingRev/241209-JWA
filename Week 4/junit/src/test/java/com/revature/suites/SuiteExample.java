package com.revature.suites;

import com.revature.tdd.repository.UsernameStorageRepoTest;
import com.revature.tdd.service.UsernameStorageServiceTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
    If you ever need to group your tests you can make use of the Junit Suite class to group your tests
    and perform actions on them in bulk. This is an easy way to run similar tests in a group instead of
    having to run them all individually through your IDE

    Using the @RunWith annotation you can specify the Junit Suite class should be used when running
    the tests for the annotated test class. This tells Junit that there are other associated test classes
    that should be executed and grouped under this main test class

    Note: if you have your test class as a suite you should not define any test methods within: they will
    not trigger when you run your tests
 */
@RunWith(Suite.class)
@SuiteClasses({
        UsernameStorageRepoTest.class,
        UsernameStorageServiceTest.class
})
public class SuiteExample {
    @BeforeClass
    public static void sharedSetup(){
        System.out.println("Runs once before all the tests in all the Suite classes");
    }

    /*
        @BeforeClass will trigger before all the associated test classes, but @Before will
        only trigger for the test class it is defined in. If you have a @Before method you need
        triggered you must define the method and annotate it in each test class that requires it
     */
    @Before
    public void setup(){
        System.out.println("runs before each test in this class only, there are no tests, so you should not see this");
    }

}
