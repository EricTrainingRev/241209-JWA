package com.revature;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRunner {

    public static WebDriver initializeDriver(){
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static void quitDriver(WebDriver driver){
        if (driver != null){
            driver.quit();
        }
    }

}
