package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsingActionAPI {

    static WebDriver driver = null;

    public static void main(String[] args) {
        /*
            When Selenium interacts with the browser it simulates
            real user interaction, but it does so through an API
            by making HTTP requests

            Most of the time this is sufficient, but when a user is expected to
            perform a more complex action (such as moving a slider) or when you
            need to simulate a page listening for and responding to certain key strokes, the
            HTTP protocol becomes insufficient

            In these scenarios you need to use the Actions API, which provides Selenium with access
            to the keyboard, mouse, scroll wheel, and pen if one is supported
         */

        try{
            driver = SeleniumRunner.initializeDriver();
            driver.get("file:///C:/Users/EricSuminski/Desktop/241209-JWA/Week%203/Selenium-Continued/src/main/resources/pages/SliderPage.html");
            WebElement slider = driver.findElement(By.tagName("input"));
            // slider.sendKeys("6"); since the input is a "range" type sendKeys will not work with the element

            /*
                You could take a trial-and-error approach to moving the slider: the default for the ActionsAPI
                when moving the mouse to a element is to place it in the center of the element. You could go
                there and start guessing how far you need to move the mouse to get the desired value. This can
                work, but it requires a lot of factors to be consistent every time you run your code, such as
                the browser being the same size.

                A more flexible approach is to calculate the size of the element and the steps of the input and
                use that information to write a set of actions that can be repeated no matter the size or shape
                of the element
             */

            System.out.println(driver.findElement(By.tagName("h1")).getText());
        } finally {
            SeleniumRunner.quitDriver(driver);
        }


    }
}
