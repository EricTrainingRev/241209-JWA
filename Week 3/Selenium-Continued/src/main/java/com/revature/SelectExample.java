package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectExample {

    static WebDriver driver = null;

    public static void main(String[] args) {
        try {
            driver = SeleniumRunner.initializeDriver();
            driver.get("C:\\Users\\EricSuminski\\Desktop\\241209-JWA\\Week 3\\Selenium-Continued\\src\\main\\resources\\pages\\SelectPage.html");
        /*
            When working with select elements you can create an actual object to represent the element
            and give yourself access to methods specific for working with select elements by finding the
            resources like normal using the findElement method, and then passing that WebElement object
            into a Select object constructor
         */
            WebElement selectElement = driver.findElement(By.tagName("select"));
            Select select = new Select(selectElement);

            /*
                When choosing the "option" you want with the Select object you can make your choice
                in one of three ways:
                - selectByIndex = starting from top of the Select element and going down, each option
                                  is assigned an index starting at 0, you make your choice like any other
                                  indexed collection
                - selectByValue = each option has a "value" attribute that the page uses to represent the
                                  actual value of the choice you make. You can target this value to make your
                                  choice using selectByValue
                - selectByVisibleText = this targets an option by the text content between the opening and
                                        closing tags of the option elements
             */

            // this should select the option in the select element
            select.selectByIndex(3);

            // we should see "fish" as the text content in the header element
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        } finally {
            SeleniumRunner.quitDriver(driver);
        }

    }

}
