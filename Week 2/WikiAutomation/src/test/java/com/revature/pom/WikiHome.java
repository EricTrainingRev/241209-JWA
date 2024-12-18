package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
    This class is going to be our Page Object Model (POM) for the Wikipedia home page. This class
    will be used to store relevant information about the web page we know we need to find and interact
    with. By storing the information in this class we have a consistent and reliable way of telling
    Selenium what actions we want to take and refactoring those actions when necessary is easy to do
    and requires little redundancy
 */
public class WikiHome {

    /*
        We add a WebDriver field to facilitate our actions in the browser. This will usually be
        whatever driver you are using for your testing, and it will be initialized in the Test Runner
     */
    private WebDriver driver;

    /*
        For each element you want to interact with you can create a WebElement field to represent that
        data, and then methods can be created to facilitate interacting with those elements

        The FindBy annotation tells the PageFactory below what locator strategy to use whenever we try
        to reference the web element. This allows us to focus on writing code to interact with the element,
        not finding and interacting. Each annotated field will be initialized by the PageFactory
     */
    @FindBy(id = "js-link-box-en")
    private WebElement englishLink;

    @FindBy(name = "search")
    private WebElement searchBar;

    public WikiHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /*
        You can use a Page Object Model to facilitate actions on the web page. In this case, we are
        creating methods that we can use in the feature file steps to complete the actions
     */

    // this method is for completing the "Given The English user is on the Wikipedia main page" step
    public void goToWikipediaHome(){
        driver.get("https://www.wikipedia.org/");
    }

    // this method is for completing the "When The English user clicks the English link"
    public void clickEnglishLink(){
        englishLink.click();
    }

    // we will leave the validation of the scenario being completed to Junit in the Then step directly

}
