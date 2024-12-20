package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiting {
    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("C:\\Users\\EricSuminski\\Desktop\\241209-JWA\\Week 2\\selenium\\src\\main\\resources\\pages\\DelayedPage.html");
            /*
                Since we know that the h1 element is going to take 2 seconds to load, we need a way to tell Selenium
                to wait for the element to be created and added to the page. We can either use an Implicit wait,
                or we can use an Explicit wait

                you can uncomment the methods below to see them in action
             */
            // set up an Implicit wait when you want to configure a universal wait time
//            usingImplicitWait(driver);
            // set up an Explitic wait when you want to configure a one-off wait time
//            usingExplicitWait(driver);

        } finally {
            if(driver != null){
                driver.quit();
            }
        }
    }

    public static void usingImplicitWait(WebDriver driver){
        /*
            An Implicit wait is a setting you can manage in the driver itself. This tells Selenium
            up to how long it should wait for an element to be interactable. This setting is nice to set
            because it provides some insurance against "flakey" tests due to situations outside our
            control, such as a bad internet connection.

            In the example below, since we know the page takes 2 seconds to create and add the h1 element
            to the page, we can set the implicit wait to 3 seconds to accommodate that loading time and to
            give ourselves one second of buffer room

            This option is a good choice when thinking of ways to protect your application from flakey runs,
            but it is not ideal for one-off scenarios. For instance, if we needed to validate that a web
            application runs quickly, having the driver's implicit wait set to 3 seconds means that EVERY
            TIME the driver needs to interact with a web element it will wait up to 3 seconds, which may end
            up causing scenarios that should fail due to taking too long to actually be marked as passing because
            the driver did not throw any exceptions when it should have. In these cases, Explicit waits are a
            more useful tool
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement delayedElement = driver.findElement(By.tagName("h1"));
        System.out.println(delayedElement.getText());
    }

    public static void usingExplicitWait(WebDriver driver){
        /*
            Explicit waits are set up using the WebDriverWait class. You provide a driver and a time
            limit for the object, and then any time you have a one-off scenario where you need to
            wait you can use the WebDriverWait object to tell Selenium to pause up to the amount of
            time specified before either continuing code execution or throwing an exception
         */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        /*
            When using the wait object you use the ExpectedConditions class to specify what you are
            actually waiting for. In this case, we are waiting for a h1 element to be located on
            the page before we continue with code execution. If the Expected Condition is not met
            then an exception will be thrown
         */
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));
        WebElement delayedElement = driver.findElement(By.tagName("h1"));
        System.out.println(delayedElement.getText());
    }
}
