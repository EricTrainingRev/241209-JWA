package com.revature;

import com.revature.pom.WikiHome;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/WikiLink.feature",
        glue = "com.revature.step",
        plugin = "pretty"
)
public class TestRunner {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WikiHome wikiHome;

    @BeforeClass
    public static void setup(){
        // if using Selenium pre-version 4
//        File d = new File("src/test/resources/chromedriver.exe");
//        System.setProperty("webdriver.{driver type}.driver",d.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wikiHome = new WikiHome(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
