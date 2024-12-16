package com.revature.steps.injection;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataInjectionSteps {
    /*
        Since Cucumber will be injecting data we can change the name of the parameter to better
        reflect the incoming value, but the {int} syntax needs to remain consistent. Depending on
        the type of data being injected the value present in the curly brackets will change
     */
    @Given("We start with the number {int}")
    public void we_start_with_the_number(Integer numOne) {
        System.out.println();
    }

    @And("We have the number {int}")
    public void we_have_the_number(Integer numTwo) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("We add the numbers together")
    public void we_add_the_numbers_together() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("We should get the number {int}")
    public void we_should_get_the_number(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
