package com.revature.steps.rule;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RuleSteps {
    @When("We try to divide by {int}")
    public void we_try_to_divide_by(Integer zero) {
        System.out.println(zero);
    }

    @Then("The system should throw an exception")
    public void the_system_should_throw_an_exception() {
        try {
            int num = 10/0;
        } catch (ArithmeticException e){
            System.out.println("Can't divide by zero");
        }
    }
}
