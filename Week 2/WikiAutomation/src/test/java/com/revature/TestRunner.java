package com.revature;

import com.revature.pom.WikiHome;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.revature.steps",
        plugin = "pretty"
)
public class TestRunner {

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
