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
        System.out.println(numOne);
    }

    @And("We have the number {int}")
    public void we_have_the_number(Integer numTwo) {
        System.out.println(numTwo);
    }

    @When("We add the numbers together")
    public void we_add_the_numbers_together() {
        System.out.println("adding numbers together");
    }

    @Then("We should get the number {int}")
    public void we_should_get_the_number(Integer sum) {
        System.out.println(sum);
    }
    @Given("We start with the word {string}")
    public void we_start_with_the_word(String wordOne) {
        System.out.println(wordOne);
    }

    @And("We have the word {string}")
    public void we_have_the_word(String wordTwo) {
        System.out.println(wordTwo);
    }

    @When("We concatenate the words")
    public void we_concatenate_the_words() {
        System.out.println("performing concatenation");
    }

    /*
        Note that Cucumber has injected the expected results into the step directly instead of the
        method associated with the step. This happens when you use a placeholder with a String value
        without wrapping the placeholder with quotes. This can be useful if you need to have different
        checks depending on the expected result, but if you are making the same check across the board
        then wrapping the placeholder in quotes so Cucumber injects the data into the method is simpler
     */
    @Then("We should have the phrase Hello world")
    public void we_should_have_the_phrase_Hello_world() {
        System.out.println("Hello world");
    }

    @Then("We should have the phrase Super-coder")
    public void we_should_have_the_phrase_Super_coder() {
        System.out.println("Super-coder");
    }
}
