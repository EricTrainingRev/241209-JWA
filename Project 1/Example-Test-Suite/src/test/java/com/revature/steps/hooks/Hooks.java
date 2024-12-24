package com.revature.steps.hooks;

import com.revature.utility.Setup;
import io.cucumber.java.Before;

public class Hooks {

    /*
        Instead of manually resetting the test database between
        runs we can use a hook and the setup class to automate
        the database reset process
     */

    @Before
    public void resetDatabase(){
        System.out.println("resetDatabase hook called");
        Setup.resetTestDatabase();
    }

}
