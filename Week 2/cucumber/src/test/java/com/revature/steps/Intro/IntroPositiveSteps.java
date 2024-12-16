package com.revature.steps.Intro;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.java.en.*; this works too

public class IntroPositiveSteps {

    @When("Some positive action is taken")
    public void some_positive_action_is_taken() {
        System.out.println("We take some positive action");
    }

    @Then("Some positive outcome should be achieved")
    public void some_positive_outcome_should_be_achieved() {
        System.out.println("Our expected positive result");
    }

}