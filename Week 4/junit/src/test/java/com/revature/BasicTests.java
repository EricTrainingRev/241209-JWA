package com.revature;

import org.junit.*;

/*
    Any class that has one or more method annotated with a Junit
    @Test decorator is considered a test class by Junit. When the
    code is compiled Junit will be able to track what classes have
    tests in them, and it can facilitate your testing process
 */
public class BasicTests {

    /*
        anatomy of a basic junit test:
        - annotate the method with @Test
        - make the test public void and give the test a name
        - write your code to be tested
     */
    // test ordering is done by method name by default
    @Test
    public void testB(){
        System.out.println("This test runs second");
    }

    @Test
    public void testA(){
        System.out.println("This this test runs first");
    }

    @Test
    public void failingTest(){
        System.out.println("This test fails because it throws an unhandled exception");
        throw new RuntimeException("this makes the test fail");
    }

    /*
        If you need to run some code before your tests execute you have two options:
        - @BeforeClass = runs before all tests one time
        - @Before = runs before each test is executed
     */

    // NOTE: this is a static method, should be used for shared resources
    @BeforeClass
    public static void runsOnceBeforeAll(){
        System.out.println("This runs once before all tests");
    }

    @Before
    public void runsBeforeEachTest(){
        System.out.println("This runs before each test is executed");
    }

    /*
        Similar to the "before" options, you can use @AfterClass and @After to perform any teardown
        operations after your tests are done
     */

    @AfterClass
    public static void runsOnceAfterAllTests(){
        System.out.println("This runs once after all tests");
    }

    @After
    public void runsAfterEachTest(){
        System.out.println("This runs after each test is executed");
    }

}
