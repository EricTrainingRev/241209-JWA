package com.revature.steps.Intro;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IntroNegativeSteps {

    @When("Some negative action is taken")
    public void some_negative_action_is_taken() {
        System.out.println("Some negative action taken");
    }

    @Then("Some negative outcome should be prevented")
    public void some_negative_outcome_should_be_prevented() {
        System.out.println("Something bad prevented");
    }
}
