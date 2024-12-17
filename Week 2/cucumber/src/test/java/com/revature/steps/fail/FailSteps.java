package com.revature.steps.fail;

import io.cucumber.java.en.Given;

public class FailSteps {

    // A step is considered to fail, and therefore the Scenario fails, if a step throws an unhandled exception
    @Given("This feature Fails")
    public void this_feature_fails(){
        throw new RuntimeException("Something went wrong in the step");
    }

}
