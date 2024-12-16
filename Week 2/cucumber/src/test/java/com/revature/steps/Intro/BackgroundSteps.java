package com.revature.steps.Intro;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BackgroundSteps {

    @Given("Some starting condition")
    public void some_starting_condition() {
        System.out.println("This is our starting condition");
    }

    /*
        You are allowed to reuse steps across scenarios and feature files, but
        you are not allowed to "overload" them: each step must have a single
        method associated with it. If you uncomment the code block below
        and try running your tests you will get a DuplicateStepException, because
        Cucumber will not know which of the methods it is supposed to execute
     */
//    @Given("Some starting condition")
//    public void someStaring_condition_2(){
//        System.out.println("This is the second staring condition");
//    }

}
