package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HandleWindowContext {

    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            String[] greeting = {"Hello","world"};
            
            driver = new ChromeDriver();
            driver.get("C:\\Users\\EricSuminski\\Desktop\\241209-JWA\\Week 2\\selenium\\src\\main\\resources\\pages\\PageOne.html");
            WebElement buttonToOpenPageTwo = driver.findElement(By.tagName("button"));
            /*
                Even though clicking the button opens a new tab in the browser, Selenium is still
                "looking" at the first page: that is its context. We need to tell Selenium to change
                its context from looking at page one to page two
             */
            buttonToOpenPageTwo.click();
            switchToNewWindow(driver,"Message Sender");
            driver.findElement(By.tagName("button")).click();
            switchToNewWindow(driver,"Message Receiver");
            System.out.println(driver.findElement(By.tagName("p")).getText());
        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }

    /*
        Selenium saves
     */
    public static void switchToNewWindow(WebDriver driver, String windowTitle){
        for(String windowHandle : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals(windowTitle)){
                break;
            }
        }
    }
}
