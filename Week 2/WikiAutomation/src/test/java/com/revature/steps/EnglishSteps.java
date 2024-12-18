package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EnglishSteps {

    @Given("The English user is on the Wikipedia main page")
    public void the_English_user_is_on_the_Wikipedia_main_page() {
        TestRunner.wikiHome.goToWikipediaHome();
    }

    @When("The English user clicks the English link")
    public void the_English_user_clicks_the_English_link() {
        TestRunner.wikiHome.clickEnglishLink();
    }

    @Then("The English user should be sent to the English homepage of Wikipedia")
    public void the_English_user_should_be_sent_to_the_English_homepage_of_Wikipedia() {
        Assert.assertEquals("Wikipedia, the free encyclopedia", TestRunner.driver.getTitle());
    }
}
