package com.revature;

import com.revature.pom.WikiHome;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    The RunWith annotation tell Junit to use the Cucumber testing framework for running our tests. We can still
    do our setup and teardown via Junit, but Junit does not have a native way of interacting with feature files.
    Any steps and hooks we design with Cucumber in mind can have their testing facilitated by Junit using Cucumber
    as the testing engine
*/
@RunWith(Cucumber.class)
/*
    We also need to tell Cucumber where to find the features and glue code for the tests. The CucumberOptions
    annotation allows us to provide this information to Cucumber programatically. Features is where you provide
    the location/s of your feature files, glue is where you provide the location/s of your step definitions.

    Include also is the plugin option: you can provide instructions for using non-standard Cucumber features
    with this configuration. The pretty plugin makes the test results easier to read and understand in the
    terminal, and the html plugin creates an html report of the test results
*/
@CucumberOptions(
        features = "classpath:features",
        glue = "com.revature.steps",
        plugin = {"pretty","html:src/test/resources/reports/html-report.html"}
)
public class TestRunner {

    /*
        Since these fields are going to be used throughout the various steps we implement we make them
        public and static for ease of access
    */
    public static WebDriver driver = null;
    public static WikiHome wikiHome;

    /*
        BeforeClass, provided by Junit, tells Junit to execute the associated method before any other
        tests. This is a useful tool for doing any setup that is needed across multiple tests, and is
        going to be more commonly used for System testing than Integration or Unit testing
     */
    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        wikiHome = new WikiHome(driver);
    }

    /*
        AfterClass, provided by Junit, tells Junit to execute the associated method after all testing is
        done. This is a useful tool for destroying any resources that need to be closed manually or generating
        reports not covered by your testing tools
     */
    @AfterClass
    public static void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
