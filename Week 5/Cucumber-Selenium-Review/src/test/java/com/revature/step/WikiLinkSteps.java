package com.revature.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import static com.revature.TestRunner.driver;
import static com.revature.TestRunner.wikiHome;

public class WikiLinkSteps {

    @Given("The user is on the wiki home page")
    public void the_user_is_on_the_wiki_home_page() {
        wikiHome.goToWikiHome();
    }

    @When("The user clicks the English link")
    public void the_user_clicks_the_English_link() {
        wikiHome.clickEnglishLink();
    }
    @Then("The user should be sent to the English version of Wikipedia")
    public void the_user_should_be_sent_to_the_English_version_of_Wikipedia() {
        String expectedTitle = "Wikipedia, the free encyclopedia";
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @When("The user clicks the {string} link of their choice")
    public void the_user_clicks_the_link_of_their_choice(String language) {
        wikiHome.clickLanguageLink(language);
    }
    @Then("The user should be sent to the {string} page")
    public void the_user_should_be_sent_to_the_page(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

}
