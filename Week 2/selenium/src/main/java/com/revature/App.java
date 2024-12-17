package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) {
        /*
            When building apps to automate the browser you will need to create a Driver object
            that will facilitate interacting with the browser
         */
        WebDriver driver = null;
        try{
            // You have to create a specific driver for the Browser you want to use
            driver = new ChromeDriver();
            // Once your browser is initialized you can use the "get" method to open a web page
            // Make sure you provide the protocol for the link
            driver.get("https://www.wikipedia.org");

            /*
                Once you are on your web page you have to be able to tell Selenium how to locate
                objects on the web page. Selenium has "locator strategies" for telling the driver
                how to find resources on the web page. Specifically, you can provide information about
                the web elements on the page to tell the driver how it is supposed to locate the element/s
                you need to interact with

                In order to click on the link to the English home page we need to decide on how we are going
                to tell the Driver to get the element for us in order to perform an action on it. Lucky for
                us, the creators of Wikipedia assigned an Id to the web element: Ids are excellent locators because
                they should always be consistent: an Id for an element should be a consistent way to target the same
                element on a web page over and over again.

                Using the "findElement" method provided by the driver, we can tell Selenium what locator
                strategy to use in order to find the element we want to interact with. We use the "By" class
                provided by Selenium to tell the Driver what strategy we are using. The findElement method
                returns a WebElement, so we can save the returned value in a variable
             */
            WebElement englishLink = driver.findElement(By.id("js-link-box-en"));

            /*
                Once we have access to the web element we can perform an action on it, such as clicking the
                link with the expectation we will go to the English home page
             */
            englishLink.click();

            /*
                Finally, we can check what the title of the web page is to validate we reached the
                location we wanted to get to
             */
            System.out.println(driver.getTitle());


        }
        finally {
            /*
                An application that finishes running will not
                automatically quite your driver, so we can use
                a finally block to check the driver was initialized,
                and if it was, quit the driver ourselves. If we don't,
                then every time we run our app a new chromedriver instance
                is created and more system resources are taken by the driver
                and kept until we manually kill the process
             */
            if(driver!=null){
                driver.quit();
            }
        }





    }

}
